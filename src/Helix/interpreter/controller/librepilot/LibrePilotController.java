package Helix.interpreter.controller.librepilot;

import Helix.interpreter.GPSPosition;
import Helix.interpreter.controller.DroneController;
import Helix.interpreter.controller.librepilot.uavtalk.UAVTalkMissingObjectException;
import Helix.interpreter.controller.librepilot.uavtalk.UAVTalkObject;
import Helix.interpreter.controller.librepilot.uavtalk.UAVTalkObjectListener;
import Helix.interpreter.controller.librepilot.uavtalk.device.FcDevice;
import Helix.interpreter.controller.librepilot.uavtalk.device.FcUsbDevice;
import Helix.interpreter.controller.simulation.SimulationController;

import java.util.ArrayList;

public class LibrePilotController extends DroneController implements PathPlanListener, GPSListener, UAVTalkObjectListener {

    private PathPlanManager pathPlanManager;
    private GPSManager gpsManager;

    volatile private boolean onAutonomousMode;
    volatile private boolean isArmed;

    volatile private GPSPosition posGPS;
    volatile private double direction;
    volatile private boolean onAction;
    volatile private ArrayList<GPSPosition> historyGPS;
    private SimulationController simulation;

    private static final String UAVO_NAME = "FlightStatus";
    private static final int MIN_SATELLITES = 14;
    private static final double DEFAULT_VELOCITY = 2;
    private static final boolean SIMULATION = true;

    public LibrePilotController() {
        FcDevice device = new FcUsbDevice();
        device.start();

        historyGPS = new ArrayList<>();

        pathPlanManager = new PathPlanManager(this, device);
        gpsManager = new GPSManager(this, device, MIN_SATELLITES);
        UAVTalkObjectListener listener = new UAVTalkObjectListener() {
            @Override
            public void onObjectUpdate(UAVTalkObject o) {
                try {
                    double yaw = (float) o.getData("Yaw");
                    yaw %= 360;
                    if(yaw < 0) {
                        yaw += 360;
                    }
                    direction = yaw;
                } catch (UAVTalkMissingObjectException e) {
                    e.printStackTrace();
                }
            }
        };
        device.setListener("AttitudeState", listener);


        posGPS = null;
        System.out.println("Waiting to get a gps position");
        while(posGPS == null);
        System.out.println("Waiting to get a good enough gps position (" + MIN_SATELLITES + " satellites)");
        gpsManager.clearHomePosition();

        direction = -1;
        System.out.println("Waiting to get initial direction");
        while(direction == -1);
        System.out.println("Done");

        isArmed = false;
        onAutonomousMode = false;
        device.requestObject(UAVO_NAME);
        device.setListener(UAVO_NAME, this);
        System.out.println("Waiting to enter en autonomous mode");
        while(!onAutonomousMode);
        System.out.println("On autonomous mode");
        if(!isArmed) {
            System.out.println("Drone is not armed. Aborting");
            System.exit(0);
        }

        if(SIMULATION) {
            simulation = new SimulationController(posGPS, direction);
        }

        System.out.println("LibrePilotController is ready");
    }

    @Override
    protected void sendTakeOff(double height) {
        onAction = true;
        pathPlanManager.sendTakeOff(height, DEFAULT_VELOCITY);
        while(onAction);
        if(SIMULATION) {
            simulation.sendTakeOff(height);
        }
    }

    @Override
    public void sendMoveTo(GPSPosition pos) {
        onAction = true;
        pathPlanManager.sendMoveTo(pos, super.homeLocation, DEFAULT_VELOCITY);
        while(onAction);
        if(SIMULATION) {
            simulation.sendMoveTo(pos);
        }
    }

    @Override
    protected void sendDirection(double direction) {
        // TODO implement this
        if(SIMULATION) {
            simulation.sendDirection(direction);
        }
    }

    @Override
    public void sendLand() {
        onAction = true;
        pathPlanManager.sendLand(DEFAULT_VELOCITY);
        while(onAction);
        if(SIMULATION) {
            simulation.addRealPath(historyGPS);
            simulation.sendLand();
        }
    }

    @Override
    public GPSPosition getGPS() {
        return new GPSPosition(posGPS);
    }

    @Override
    public double getDirection() {
        return direction;
    }

    @Override
    public void onGPSUpdate(GPSPosition newPos) {
        posGPS = newPos;
        historyGPS.add(new GPSPosition(newPos));
    }

    @Override
    public void onProgressUpdate(float progress) {
        System.out.println("Progress of actual instruction: " + progress*100 + "%");
    }

    @Override
    public void onFinishPath() {
        onAction = false;
        System.out.println("-----------------------");
        System.out.println("Waypoint reached");
        System.out.println("-----------------------");
    }

    @Override
    public void onError() {
        onAction = false;
        System.out.println("Error flying. Aborting");
        System.exit(1);
    }

    @Override
    public void onObjectUpdate(UAVTalkObject o) {
        //If the flight mode is not pathplanner, it means that the pilot has changed to manual control, so aborting program
        try {
            String flightMode = (String) o.getData("FlightMode");
            if(flightMode == null) {
                System.exit(1);
            }
            boolean isAutonomous = flightMode.equals("PathPlanner");
            if(onAutonomousMode && !isAutonomous) {
                onAutonomousMode = false;
                System.out.println("--------------------------------------------------------");
                System.err.println("Pilot has changed to " + flightMode + " (manual control)");
                //System.exit(0);
            } else {
                onAutonomousMode = isAutonomous;
            }

            isArmed = o.getData("Armed").equals("Armed");
        } catch (UAVTalkMissingObjectException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}