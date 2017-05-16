/**
 ******************************************************************************
 *
 * @file       FlightStatus.java
 * @author     The OpenPilot Team, http://www.openpilot.org Copyright (C) 2010.
 * @brief      Template for an uavobject in java
 *             This is a autogenerated file!! Do not modify and expect a result.
 *             Contains major flight status information for other modules.
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
Contains major flight status information for other modules.

generated from flightstatus.xml
 **/
public class FlightStatus extends UAVDataObject {

	public FlightStatus() {
		super(OBJID, ISSINGLEINST, ISSETTINGS, NAME);
		
		List<UAVObjectField> fields = new ArrayList<UAVObjectField>();
		

		List<String> ArmedElemNames = new ArrayList<String>();
		ArmedElemNames.add("0");
		List<String> ArmedEnumOptions = new ArrayList<String>();
		ArmedEnumOptions.add("Disarmed");
		ArmedEnumOptions.add("Arming");
		ArmedEnumOptions.add("Armed");
		fields.add( new UAVObjectField("Armed", "", UAVObjectField.FieldType.ENUM, ArmedElemNames, ArmedEnumOptions) );

		List<String> FlightModeElemNames = new ArrayList<String>();
		FlightModeElemNames.add("0");
		List<String> FlightModeEnumOptions = new ArrayList<String>();
		FlightModeEnumOptions.add("Manual");
		FlightModeEnumOptions.add("Stabilized1");
		FlightModeEnumOptions.add("Stabilized2");
		FlightModeEnumOptions.add("Stabilized3");
		FlightModeEnumOptions.add("Stabilized4");
		FlightModeEnumOptions.add("Stabilized5");
		FlightModeEnumOptions.add("Stabilized6");
		FlightModeEnumOptions.add("PositionHold");
		FlightModeEnumOptions.add("CourseLock");
		FlightModeEnumOptions.add("VelocityRoam");
		FlightModeEnumOptions.add("HomeLeash");
		FlightModeEnumOptions.add("AbsolutePosition");
		FlightModeEnumOptions.add("ReturnToBase");
		FlightModeEnumOptions.add("Land");
		FlightModeEnumOptions.add("PathPlanner");
		FlightModeEnumOptions.add("POI");
		FlightModeEnumOptions.add("AutoCruise");
		FlightModeEnumOptions.add("AutoTakeoff");
		FlightModeEnumOptions.add("AutoTune");
		fields.add( new UAVObjectField("FlightMode", "", UAVObjectField.FieldType.ENUM, FlightModeElemNames, FlightModeEnumOptions) );

		List<String> AlwaysStabilizeWhenArmedElemNames = new ArrayList<String>();
		AlwaysStabilizeWhenArmedElemNames.add("0");
		List<String> AlwaysStabilizeWhenArmedEnumOptions = new ArrayList<String>();
		AlwaysStabilizeWhenArmedEnumOptions.add("False");
		AlwaysStabilizeWhenArmedEnumOptions.add("True");
		fields.add( new UAVObjectField("AlwaysStabilizeWhenArmed", "", UAVObjectField.FieldType.ENUM, AlwaysStabilizeWhenArmedElemNames, AlwaysStabilizeWhenArmedEnumOptions) );

		List<String> FlightModeAssistElemNames = new ArrayList<String>();
		FlightModeAssistElemNames.add("0");
		List<String> FlightModeAssistEnumOptions = new ArrayList<String>();
		FlightModeAssistEnumOptions.add("None");
		FlightModeAssistEnumOptions.add("GPSAssist_PrimaryThrust");
		FlightModeAssistEnumOptions.add("GPSAssist");
		fields.add( new UAVObjectField("FlightModeAssist", "", UAVObjectField.FieldType.ENUM, FlightModeAssistElemNames, FlightModeAssistEnumOptions) );

		List<String> AssistedControlStateElemNames = new ArrayList<String>();
		AssistedControlStateElemNames.add("0");
		List<String> AssistedControlStateEnumOptions = new ArrayList<String>();
		AssistedControlStateEnumOptions.add("Primary");
		AssistedControlStateEnumOptions.add("Brake");
		AssistedControlStateEnumOptions.add("Hold");
		fields.add( new UAVObjectField("AssistedControlState", "", UAVObjectField.FieldType.ENUM, AssistedControlStateElemNames, AssistedControlStateEnumOptions) );

		List<String> AssistedThrottleStateElemNames = new ArrayList<String>();
		AssistedThrottleStateElemNames.add("0");
		List<String> AssistedThrottleStateEnumOptions = new ArrayList<String>();
		AssistedThrottleStateEnumOptions.add("Manual");
		AssistedThrottleStateEnumOptions.add("Auto");
		AssistedThrottleStateEnumOptions.add("AutoOverride");
		fields.add( new UAVObjectField("AssistedThrottleState", "", UAVObjectField.FieldType.ENUM, AssistedThrottleStateElemNames, AssistedThrottleStateEnumOptions) );

		List<String> ControlChainElemNames = new ArrayList<String>();
		ControlChainElemNames.add("Stabilization");
		ControlChainElemNames.add("PathFollower");
		ControlChainElemNames.add("PathPlanner");
		List<String> ControlChainEnumOptions = new ArrayList<String>();
		ControlChainEnumOptions.add("False");
		ControlChainEnumOptions.add("True");
		fields.add( new UAVObjectField("ControlChain", "bool", UAVObjectField.FieldType.ENUM, ControlChainElemNames, ControlChainEnumOptions) );


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
    	metadata.flightTelemetryUpdatePeriod = 5000;
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
		getField("Armed").setValue("Disarmed");
		getField("AlwaysStabilizeWhenArmed").setValue("False");
		getField("AssistedControlState").setValue("Primary");
		getField("AssistedThrottleState").setValue("Manual");

	}

	/**
	 * Create a clone of this object, a new instance ID must be specified.
	 * Do not use this function directly to create new instances, the
	 * UAVObjectManager should be used instead.
	 */
	public UAVDataObject clone(long instID) {
		// TODO: Need to get specific instance to clone
		try {
			FlightStatus obj = new FlightStatus();
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
		return new FlightStatus();
	}

	/**
	 * Static function to retrieve an instance of the object.
	 */
	public FlightStatus GetInstance(UAVObjectManager objMngr, long instID)
	{
	    return (FlightStatus)(objMngr.getObject(FlightStatus.OBJID, instID));
	}

	// Constants
	protected static final long OBJID = 0x24D25E28l;
	protected static final String NAME = "FlightStatus";
	protected static String DESCRIPTION = "Contains major flight status information for other modules.";
	protected static final boolean ISSINGLEINST = 1 > 0;
	protected static final boolean ISSETTINGS = 0 > 0;
	protected static int NUMBYTES = 0;


}
