package Helix.interpreter.controller.librepilot;

import Helix.interpreter.GPSPosition;
import Helix.interpreter.Position;
import Helix.interpreter.controller.librepilot.uavtalk.UAVTalkObject;
import Helix.interpreter.controller.librepilot.uavtalk.UAVTalkObjectInstance;
import Helix.interpreter.controller.librepilot.uavtalk.Utils;
import Helix.interpreter.controller.librepilot.uavtalk.device.FcDevice;

public class Waypoint extends Position {

    public double velocity;
    public double progress;

    public Waypoint(GPSPosition pos, GPSPosition homePosition, double velocity) {
        super(pos.toRelative(homePosition));
        this.velocity = velocity;
        progress = 0;
    }

    public Waypoint(Waypoint waypoint) {
        super(waypoint);
        this.velocity = waypoint.velocity;
        progress = 0;
    }

    public void upload(FcDevice device) {
        updatePathPlan(device);
        uploadPathAction(device);
        uploadWaypoint(device, this, 0);
        Waypoint holdPos = new Waypoint(this); // This is an auxiliar waypoint which will come after this one in order to detect when the original ends
        holdPos.velocity = 0;
        holdPos.move(new Position(10, 10, 10)); // To move it from the final position of the drone, so the progress won't be 100%
        uploadWaypoint(device, holdPos, 1);
    }

    private void updatePathPlan(FcDevice device) {
        byte data[] = new byte[device.getObjectTree().getXmlObjects().get("PathPlan").getLength()];
        data = Utils.writeInArray(Utils.toReversedBytes((short) 2), data, 0);
        data = Utils.writeInArray(Utils.toReversedBytes((short) 1), data, 2);
        //data[4] = (byte) Utils.crc8(data, 0, 4);
        data[4] = 19; //FIXME discover how this crc is computed for avoid hardcoding
        UAVTalkObjectInstance instance = new UAVTalkObjectInstance(0, data);
        UAVTalkObject pathPlan = device.getObjectTree().getObjectFromName("PathPlan");
        pathPlan.setInstance(instance);
        device.sendSettingsObject("PathPlan", 0);
    }

    private void uploadPathAction(FcDevice device) {
        byte data[] = new byte[device.getObjectTree().getXmlObjects().get("PathAction").getLength()];
        UAVTalkObjectInstance instance = new UAVTalkObjectInstance(0, data);
        UAVTalkObject pathActions = device.getObjectTree().getObjectFromName("PathAction");
        pathActions.setInstance(instance);
        device.sendSettingsObject("PathAction", 0);
//        byte value[] = new byte[1];
//        value[0] = 0;
//        device.sendSettingsObject("PathAction", 0, "Mode", 0, value);
    }

    private void uploadWaypoint(FcDevice device, Waypoint waypoint, int id) {
        byte data[] = new byte[device.getObjectTree().getXmlObjects().get("Waypoint").getLength()];
        //Adding the new instance
        UAVTalkObjectInstance instance = new UAVTalkObjectInstance(id, data);
        UAVTalkObject waypoints = device.getObjectTree().getObjectFromName("Waypoint");
        waypoints.setInstance(instance);

        //Setting the position of the new instance
        sendField(device, id, "Position", 0, waypoint.lat);
        sendField(device, id, "Position", 1, waypoint.lng);
        sendField(device, id, "Position", 2, -waypoint.alt);
        sendField(device, id, "Velocity", 0, waypoint.velocity);
        byte action[] = new byte[1];
        action[0] = 0;
        device.sendSettingsObject("Waypoint", id, "Action", 0, action);
    }

    private void sendField(FcDevice device, int instanceID, String fieldName, int elementID, double value) {
        device.sendSettingsObject("Waypoint", instanceID, fieldName, elementID, Utils.floatToByteArrayRev((float) value));
    }


    public void delete() {
        // TODO delete waypoints from device
    }
}
