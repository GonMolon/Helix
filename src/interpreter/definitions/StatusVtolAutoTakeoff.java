/**
 ******************************************************************************
 *
 * @file       StatusVtolAutoTakeoff.java
 * @author     The OpenPilot Team, http://www.openpilot.org Copyright (C) 2010.
 * @brief      Template for an uavobject in java
 *             This is a autogenerated file!! Do not modify and expect a result.
 *             Status of a AutoTakeoff autopilot
 *
 * @see        The GNU Public License (GPL) Version 3
 *
 *****************************************************************************/
/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package org.openpilot.uavtalk.uavobjects;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.openpilot.uavtalk.UAVObjectManager;
import org.openpilot.uavtalk.UAVObject;
import org.openpilot.uavtalk.UAVDataObject;
import org.openpilot.uavtalk.UAVObjectField;

/**
Status of a AutoTakeoff autopilot

generated from statusvtolautotakeoff.xml
 **/
public class StatusVtolAutoTakeoff extends UAVDataObject {

	public StatusVtolAutoTakeoff() {
		super(OBJID, ISSINGLEINST, ISSETTINGS, NAME);
		
		List<UAVObjectField> fields = new ArrayList<UAVObjectField>();
		

		List<String> AltitudeAtStateElemNames = new ArrayList<String>();
		AltitudeAtStateElemNames.add("0");
		AltitudeAtStateElemNames.add("1");
		AltitudeAtStateElemNames.add("2");
		AltitudeAtStateElemNames.add("3");
		AltitudeAtStateElemNames.add("4");
		AltitudeAtStateElemNames.add("5");
		AltitudeAtStateElemNames.add("6");
		AltitudeAtStateElemNames.add("7");
		AltitudeAtStateElemNames.add("8");
		AltitudeAtStateElemNames.add("9");
		fields.add( new UAVObjectField("AltitudeAtState", "m", UAVObjectField.FieldType.FLOAT32, AltitudeAtStateElemNames, null) );

		List<String> StateElemNames = new ArrayList<String>();
		StateElemNames.add("0");
		List<String> StateEnumOptions = new ArrayList<String>();
		StateEnumOptions.add("Inactive");
		StateEnumOptions.add("CheckState");
		StateEnumOptions.add("SlowStart");
		StateEnumOptions.add("ThrustUp");
		StateEnumOptions.add("Takeoff");
		StateEnumOptions.add("Hold");
		StateEnumOptions.add("ThrustDown");
		StateEnumOptions.add("ThrustOff");
		StateEnumOptions.add("Disarmed");
		fields.add( new UAVObjectField("State", "", UAVObjectField.FieldType.ENUM, StateElemNames, StateEnumOptions) );

		List<String> StateExitReasonElemNames = new ArrayList<String>();
		StateExitReasonElemNames.add("0");
		StateExitReasonElemNames.add("1");
		StateExitReasonElemNames.add("2");
		StateExitReasonElemNames.add("3");
		StateExitReasonElemNames.add("4");
		StateExitReasonElemNames.add("5");
		StateExitReasonElemNames.add("6");
		StateExitReasonElemNames.add("7");
		StateExitReasonElemNames.add("8");
		StateExitReasonElemNames.add("9");
		List<String> StateExitReasonEnumOptions = new ArrayList<String>();
		StateExitReasonEnumOptions.add("None");
		StateExitReasonEnumOptions.add("ArrivedAtAlt");
		StateExitReasonEnumOptions.add("ZeroThrust");
		StateExitReasonEnumOptions.add("PositionError");
		StateExitReasonEnumOptions.add("Timeout");
		fields.add( new UAVObjectField("StateExitReason", "", UAVObjectField.FieldType.ENUM, StateExitReasonElemNames, StateExitReasonEnumOptions) );

		List<String> AltitudeStateElemNames = new ArrayList<String>();
		AltitudeStateElemNames.add("0");
		List<String> AltitudeStateEnumOptions = new ArrayList<String>();
		AltitudeStateEnumOptions.add("High");
		AltitudeStateEnumOptions.add("Low");
		fields.add( new UAVObjectField("AltitudeState", "", UAVObjectField.FieldType.ENUM, AltitudeStateElemNames, AltitudeStateEnumOptions) );

		List<String> ControlStateElemNames = new ArrayList<String>();
		ControlStateElemNames.add("0");
		List<String> ControlStateEnumOptions = new ArrayList<String>();
		ControlStateEnumOptions.add("WaitForArmed");
		ControlStateEnumOptions.add("WaitForMidThrottle");
		ControlStateEnumOptions.add("RequireUnarmedFirst");
		ControlStateEnumOptions.add("Initiate");
		ControlStateEnumOptions.add("PositionHold");
		ControlStateEnumOptions.add("Abort");
		fields.add( new UAVObjectField("ControlState", "", UAVObjectField.FieldType.ENUM, ControlStateElemNames, ControlStateEnumOptions) );


		// Compute the number of bytes for this object
		int numBytes = 0;
		ListIterator<UAVObjectField> li = fields.listIterator();
		while(li.hasNext()) {
			numBytes += li.next().getNumBytes();
		}
		NUMBYTES = numBytes;

		// Initialize object
		initializeFields(fields, ByteBuffer.allocate(NUMBYTES), NUMBYTES);
		// Set the default field values
		setDefaultFieldValues();
		// Set the object description
		setDescription(DESCRIPTION);
	}

	/**
	 * Create a Metadata object filled with default values for this object
	 * @return Metadata object with default values
	 */
	public Metadata getDefaultMetadata() {
		UAVObject.Metadata metadata = new UAVObject.Metadata();
    	metadata.flags =
		    UAVObject.Metadata.AccessModeNum(UAVObject.AccessMode.ACCESS_READWRITE) << UAVOBJ_ACCESS_SHIFT |
		    UAVObject.Metadata.AccessModeNum(UAVObject.AccessMode.ACCESS_READWRITE) << UAVOBJ_GCS_ACCESS_SHIFT |
		    0 << UAVOBJ_TELEMETRY_ACKED_SHIFT |
		    0 << UAVOBJ_GCS_TELEMETRY_ACKED_SHIFT |
		    UAVObject.Metadata.UpdateModeNum(UAVObject.UpdateMode.UPDATEMODE_ONCHANGE) << UAVOBJ_TELEMETRY_UPDATE_MODE_SHIFT |
		    UAVObject.Metadata.UpdateModeNum(UAVObject.UpdateMode.UPDATEMODE_MANUAL) << UAVOBJ_GCS_TELEMETRY_UPDATE_MODE_SHIFT |
		    UAVObject.Metadata.UpdateModeNum(UAVObject.UpdateMode.UPDATEMODE_MANUAL) << UAVOBJ_LOGGING_UPDATE_MODE_SHIFT;
    	metadata.flightTelemetryUpdatePeriod = 500;
    	metadata.gcsTelemetryUpdatePeriod = 0;
    	metadata.loggingUpdatePeriod = 0;
 
		return metadata;
	}

	/**
	 * Initialize object fields with the default values.
	 * If a default value is not specified the object fields
	 * will be initialized to zero.
	 */
	public void setDefaultFieldValues()
	{

	}

	/**
	 * Create a clone of this object, a new instance ID must be specified.
	 * Do not use this function directly to create new instances, the
	 * UAVObjectManager should be used instead.
	 */
	public UAVDataObject clone(long instID) {
		// TODO: Need to get specific instance to clone
		try {
			StatusVtolAutoTakeoff obj = new StatusVtolAutoTakeoff();
			obj.initialize(instID, this.getMetaObject());
			return obj;
		} catch  (Exception e) {
			return null;
		}
	}

	/**
	 * Returns a new instance of this UAVDataObject with default field
	 * values. This is intended to be used by 'reset to default' functionality.
	 * 
	 * @return new instance of this class with default values.
	 */
	@Override
	public UAVDataObject getDefaultInstance(){
		return new StatusVtolAutoTakeoff();
	}

	/**
	 * Static function to retrieve an instance of the object.
	 */
	public StatusVtolAutoTakeoff GetInstance(UAVObjectManager objMngr, long instID)
	{
	    return (StatusVtolAutoTakeoff)(objMngr.getObject(StatusVtolAutoTakeoff.OBJID, instID));
	}

	// Constants
	protected static final long OBJID = 0x9FD49FECl;
	protected static final String NAME = "StatusVtolAutoTakeoff";
	protected static String DESCRIPTION = "Status of a AutoTakeoff autopilot";
	protected static final boolean ISSINGLEINST = 1 > 0;
	protected static final boolean ISSETTINGS = 0 > 0;
	protected static int NUMBYTES = 0;


}
