/**
 ******************************************************************************
 *
 * @file       AttitudeSettings.java
 * @author     The OpenPilot Team, http://www.openpilot.org Copyright (C) 2010.
 * @brief      Template for an uavobject in java
 *             This is a autogenerated file!! Do not modify and expect a result.
 *             Settings for the @ref Attitude module used on CopterControl
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
Settings for the @ref Attitude module used on CopterControl

generated from attitudesettings.xml
 **/
public class AttitudeSettings extends UAVDataObject {

	public AttitudeSettings() {
		super(OBJID, ISSINGLEINST, ISSETTINGS, NAME);
		
		List<UAVObjectField> fields = new ArrayList<UAVObjectField>();
		

		List<String> BoardRotationElemNames = new ArrayList<String>();
		BoardRotationElemNames.add("Roll");
		BoardRotationElemNames.add("Pitch");
		BoardRotationElemNames.add("Yaw");
		fields.add( new UAVObjectField("BoardRotation", "deg", UAVObjectField.FieldType.FLOAT32, BoardRotationElemNames, null) );

		List<String> BoardLevelTrimElemNames = new ArrayList<String>();
		BoardLevelTrimElemNames.add("Roll");
		BoardLevelTrimElemNames.add("Pitch");
		fields.add( new UAVObjectField("BoardLevelTrim", "deg", UAVObjectField.FieldType.FLOAT32, BoardLevelTrimElemNames, null) );

		List<String> AccelKpElemNames = new ArrayList<String>();
		AccelKpElemNames.add("0");
		fields.add( new UAVObjectField("AccelKp", "channel", UAVObjectField.FieldType.FLOAT32, AccelKpElemNames, null) );

		List<String> AccelKiElemNames = new ArrayList<String>();
		AccelKiElemNames.add("0");
		fields.add( new UAVObjectField("AccelKi", "channel", UAVObjectField.FieldType.FLOAT32, AccelKiElemNames, null) );

		List<String> MagKiElemNames = new ArrayList<String>();
		MagKiElemNames.add("0");
		fields.add( new UAVObjectField("MagKi", "", UAVObjectField.FieldType.FLOAT32, MagKiElemNames, null) );

		List<String> MagKpElemNames = new ArrayList<String>();
		MagKpElemNames.add("0");
		fields.add( new UAVObjectField("MagKp", "", UAVObjectField.FieldType.FLOAT32, MagKpElemNames, null) );

		List<String> AccelTauElemNames = new ArrayList<String>();
		AccelTauElemNames.add("0");
		fields.add( new UAVObjectField("AccelTau", "", UAVObjectField.FieldType.FLOAT32, AccelTauElemNames, null) );

		List<String> YawBiasRateElemNames = new ArrayList<String>();
		YawBiasRateElemNames.add("0");
		fields.add( new UAVObjectField("YawBiasRate", "channel", UAVObjectField.FieldType.FLOAT32, YawBiasRateElemNames, null) );

		List<String> BoardSteadyMaxVarianceElemNames = new ArrayList<String>();
		BoardSteadyMaxVarianceElemNames.add("0");
		fields.add( new UAVObjectField("BoardSteadyMaxVariance", "(deg/s)^2", UAVObjectField.FieldType.FLOAT32, BoardSteadyMaxVarianceElemNames, null) );

		List<String> ZeroDuringArmingElemNames = new ArrayList<String>();
		ZeroDuringArmingElemNames.add("0");
		List<String> ZeroDuringArmingEnumOptions = new ArrayList<String>();
		ZeroDuringArmingEnumOptions.add("False");
		ZeroDuringArmingEnumOptions.add("True");
		fields.add( new UAVObjectField("ZeroDuringArming", "channel", UAVObjectField.FieldType.ENUM, ZeroDuringArmingElemNames, ZeroDuringArmingEnumOptions) );

		List<String> BiasCorrectGyroElemNames = new ArrayList<String>();
		BiasCorrectGyroElemNames.add("0");
		List<String> BiasCorrectGyroEnumOptions = new ArrayList<String>();
		BiasCorrectGyroEnumOptions.add("False");
		BiasCorrectGyroEnumOptions.add("True");
		fields.add( new UAVObjectField("BiasCorrectGyro", "channel", UAVObjectField.FieldType.ENUM, BiasCorrectGyroElemNames, BiasCorrectGyroEnumOptions) );

		List<String> InitialZeroWhenBoardSteadyElemNames = new ArrayList<String>();
		InitialZeroWhenBoardSteadyElemNames.add("0");
		List<String> InitialZeroWhenBoardSteadyEnumOptions = new ArrayList<String>();
		InitialZeroWhenBoardSteadyEnumOptions.add("False");
		InitialZeroWhenBoardSteadyEnumOptions.add("True");
		fields.add( new UAVObjectField("InitialZeroWhenBoardSteady", "", UAVObjectField.FieldType.ENUM, InitialZeroWhenBoardSteadyElemNames, InitialZeroWhenBoardSteadyEnumOptions) );

		List<String> TrimFlightElemNames = new ArrayList<String>();
		TrimFlightElemNames.add("0");
		List<String> TrimFlightEnumOptions = new ArrayList<String>();
		TrimFlightEnumOptions.add("NORMAL");
		TrimFlightEnumOptions.add("START");
		TrimFlightEnumOptions.add("LOAD");
		fields.add( new UAVObjectField("TrimFlight", "channel", UAVObjectField.FieldType.ENUM, TrimFlightElemNames, TrimFlightEnumOptions) );


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
		    1 << UAVOBJ_TELEMETRY_ACKED_SHIFT |
		    1 << UAVOBJ_GCS_TELEMETRY_ACKED_SHIFT |
		    UAVObject.Metadata.UpdateModeNum(UAVObject.UpdateMode.UPDATEMODE_ONCHANGE) << UAVOBJ_TELEMETRY_UPDATE_MODE_SHIFT |
		    UAVObject.Metadata.UpdateModeNum(UAVObject.UpdateMode.UPDATEMODE_ONCHANGE) << UAVOBJ_GCS_TELEMETRY_UPDATE_MODE_SHIFT |
		    UAVObject.Metadata.UpdateModeNum(UAVObject.UpdateMode.UPDATEMODE_MANUAL) << UAVOBJ_LOGGING_UPDATE_MODE_SHIFT;
    	metadata.flightTelemetryUpdatePeriod = 0;
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
		getField("BoardRotation").setValue(0,0);
		getField("BoardRotation").setValue(0,1);
		getField("BoardRotation").setValue(0,2);
		getField("BoardLevelTrim").setValue(0,0);
		getField("BoardLevelTrim").setValue(0,1);
		getField("AccelKp").setValue(0.05);
		getField("AccelKi").setValue(0.0001);
		getField("MagKi").setValue(1e-06);
		getField("MagKp").setValue(0.01);
		getField("AccelTau").setValue(0.05);
		getField("YawBiasRate").setValue(1e-06);
		getField("BoardSteadyMaxVariance").setValue(5);
		getField("ZeroDuringArming").setValue("True");
		getField("BiasCorrectGyro").setValue("True");
		getField("InitialZeroWhenBoardSteady").setValue("True");
		getField("TrimFlight").setValue("NORMAL");

	}

	/**
	 * Create a clone of this object, a new instance ID must be specified.
	 * Do not use this function directly to create new instances, the
	 * UAVObjectManager should be used instead.
	 */
	public UAVDataObject clone(long instID) {
		// TODO: Need to get specific instance to clone
		try {
			AttitudeSettings obj = new AttitudeSettings();
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
		return new AttitudeSettings();
	}

	/**
	 * Static function to retrieve an instance of the object.
	 */
	public AttitudeSettings GetInstance(UAVObjectManager objMngr, long instID)
	{
	    return (AttitudeSettings)(objMngr.getObject(AttitudeSettings.OBJID, instID));
	}

	// Constants
	protected static final long OBJID = 0xB20D3DEl;
	protected static final String NAME = "AttitudeSettings";
	protected static String DESCRIPTION = "Settings for the @ref Attitude module used on CopterControl";
	protected static final boolean ISSINGLEINST = 1 > 0;
	protected static final boolean ISSETTINGS = 1 > 0;
	protected static int NUMBYTES = 0;


}
