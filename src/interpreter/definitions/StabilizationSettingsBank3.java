/**
 ******************************************************************************
 *
 * @file       StabilizationSettingsBank3.java
 * @author     The OpenPilot Team, http://www.openpilot.org Copyright (C) 2010.
 * @brief      Template for an uavobject in java
 *             This is a autogenerated file!! Do not modify and expect a result.
 *             Currently selected PID bank
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
Currently selected PID bank

generated from stabilizationsettingsbank3.xml
 **/
public class StabilizationSettingsBank3 extends UAVDataObject {

	public StabilizationSettingsBank3() {
		super(OBJID, ISSINGLEINST, ISSETTINGS, NAME);
		
		List<UAVObjectField> fields = new ArrayList<UAVObjectField>();
		

		List<String> RollRatePIDElemNames = new ArrayList<String>();
		RollRatePIDElemNames.add("Kp");
		RollRatePIDElemNames.add("Ki");
		RollRatePIDElemNames.add("Kd");
		RollRatePIDElemNames.add("ILimit");
		fields.add( new UAVObjectField("RollRatePID", "", UAVObjectField.FieldType.FLOAT32, RollRatePIDElemNames, null) );

		List<String> PitchRatePIDElemNames = new ArrayList<String>();
		PitchRatePIDElemNames.add("Kp");
		PitchRatePIDElemNames.add("Ki");
		PitchRatePIDElemNames.add("Kd");
		PitchRatePIDElemNames.add("ILimit");
		fields.add( new UAVObjectField("PitchRatePID", "", UAVObjectField.FieldType.FLOAT32, PitchRatePIDElemNames, null) );

		List<String> YawRatePIDElemNames = new ArrayList<String>();
		YawRatePIDElemNames.add("Kp");
		YawRatePIDElemNames.add("Ki");
		YawRatePIDElemNames.add("Kd");
		YawRatePIDElemNames.add("ILimit");
		fields.add( new UAVObjectField("YawRatePID", "", UAVObjectField.FieldType.FLOAT32, YawRatePIDElemNames, null) );

		List<String> RollPIElemNames = new ArrayList<String>();
		RollPIElemNames.add("Kp");
		RollPIElemNames.add("Ki");
		RollPIElemNames.add("ILimit");
		fields.add( new UAVObjectField("RollPI", "", UAVObjectField.FieldType.FLOAT32, RollPIElemNames, null) );

		List<String> PitchPIElemNames = new ArrayList<String>();
		PitchPIElemNames.add("Kp");
		PitchPIElemNames.add("Ki");
		PitchPIElemNames.add("ILimit");
		fields.add( new UAVObjectField("PitchPI", "", UAVObjectField.FieldType.FLOAT32, PitchPIElemNames, null) );

		List<String> YawPIElemNames = new ArrayList<String>();
		YawPIElemNames.add("Kp");
		YawPIElemNames.add("Ki");
		YawPIElemNames.add("ILimit");
		fields.add( new UAVObjectField("YawPI", "", UAVObjectField.FieldType.FLOAT32, YawPIElemNames, null) );

		List<String> ManualRateElemNames = new ArrayList<String>();
		ManualRateElemNames.add("Roll");
		ManualRateElemNames.add("Pitch");
		ManualRateElemNames.add("Yaw");
		fields.add( new UAVObjectField("ManualRate", "degrees/sec", UAVObjectField.FieldType.UINT16, ManualRateElemNames, null) );

		List<String> MaximumRateElemNames = new ArrayList<String>();
		MaximumRateElemNames.add("Roll");
		MaximumRateElemNames.add("Pitch");
		MaximumRateElemNames.add("Yaw");
		fields.add( new UAVObjectField("MaximumRate", "degrees/sec", UAVObjectField.FieldType.UINT16, MaximumRateElemNames, null) );

		List<String> RollMaxElemNames = new ArrayList<String>();
		RollMaxElemNames.add("0");
		fields.add( new UAVObjectField("RollMax", "degrees", UAVObjectField.FieldType.UINT8, RollMaxElemNames, null) );

		List<String> PitchMaxElemNames = new ArrayList<String>();
		PitchMaxElemNames.add("0");
		fields.add( new UAVObjectField("PitchMax", "degrees", UAVObjectField.FieldType.UINT8, PitchMaxElemNames, null) );

		List<String> YawMaxElemNames = new ArrayList<String>();
		YawMaxElemNames.add("0");
		fields.add( new UAVObjectField("YawMax", "degrees", UAVObjectField.FieldType.UINT8, YawMaxElemNames, null) );

		List<String> StickExpoElemNames = new ArrayList<String>();
		StickExpoElemNames.add("Roll");
		StickExpoElemNames.add("Pitch");
		StickExpoElemNames.add("Yaw");
		fields.add( new UAVObjectField("StickExpo", "percent", UAVObjectField.FieldType.INT8, StickExpoElemNames, null) );

		List<String> AcroInsanityFactorElemNames = new ArrayList<String>();
		AcroInsanityFactorElemNames.add("Roll");
		AcroInsanityFactorElemNames.add("Pitch");
		AcroInsanityFactorElemNames.add("Yaw");
		fields.add( new UAVObjectField("AcroInsanityFactor", "percent", UAVObjectField.FieldType.UINT8, AcroInsanityFactorElemNames, null) );

		List<String> EnablePiroCompElemNames = new ArrayList<String>();
		EnablePiroCompElemNames.add("0");
		List<String> EnablePiroCompEnumOptions = new ArrayList<String>();
		EnablePiroCompEnumOptions.add("False");
		EnablePiroCompEnumOptions.add("True");
		fields.add( new UAVObjectField("EnablePiroComp", "", UAVObjectField.FieldType.ENUM, EnablePiroCompElemNames, EnablePiroCompEnumOptions) );

		List<String> FpvCamTiltCompensationElemNames = new ArrayList<String>();
		FpvCamTiltCompensationElemNames.add("0");
		fields.add( new UAVObjectField("FpvCamTiltCompensation", "deg", UAVObjectField.FieldType.UINT8, FpvCamTiltCompensationElemNames, null) );

		List<String> EnableThrustPIDScalingElemNames = new ArrayList<String>();
		EnableThrustPIDScalingElemNames.add("0");
		List<String> EnableThrustPIDScalingEnumOptions = new ArrayList<String>();
		EnableThrustPIDScalingEnumOptions.add("False");
		EnableThrustPIDScalingEnumOptions.add("True");
		fields.add( new UAVObjectField("EnableThrustPIDScaling", "", UAVObjectField.FieldType.ENUM, EnableThrustPIDScalingElemNames, EnableThrustPIDScalingEnumOptions) );

		List<String> ThrustPIDScaleCurveElemNames = new ArrayList<String>();
		ThrustPIDScaleCurveElemNames.add("0");
		ThrustPIDScaleCurveElemNames.add("25");
		ThrustPIDScaleCurveElemNames.add("50");
		ThrustPIDScaleCurveElemNames.add("75");
		ThrustPIDScaleCurveElemNames.add("100");
		fields.add( new UAVObjectField("ThrustPIDScaleCurve", "percent", UAVObjectField.FieldType.INT8, ThrustPIDScaleCurveElemNames, null) );

		List<String> ThrustPIDScaleSourceElemNames = new ArrayList<String>();
		ThrustPIDScaleSourceElemNames.add("0");
		List<String> ThrustPIDScaleSourceEnumOptions = new ArrayList<String>();
		ThrustPIDScaleSourceEnumOptions.add("ManualControlThrottle");
		ThrustPIDScaleSourceEnumOptions.add("StabilizationDesiredThrust");
		ThrustPIDScaleSourceEnumOptions.add("ActuatorDesiredThrust");
		fields.add( new UAVObjectField("ThrustPIDScaleSource", "", UAVObjectField.FieldType.ENUM, ThrustPIDScaleSourceElemNames, ThrustPIDScaleSourceEnumOptions) );

		List<String> ThrustPIDScaleTargetElemNames = new ArrayList<String>();
		ThrustPIDScaleTargetElemNames.add("0");
		List<String> ThrustPIDScaleTargetEnumOptions = new ArrayList<String>();
		ThrustPIDScaleTargetEnumOptions.add("PID");
		ThrustPIDScaleTargetEnumOptions.add("PI");
		ThrustPIDScaleTargetEnumOptions.add("PD");
		ThrustPIDScaleTargetEnumOptions.add("ID");
		ThrustPIDScaleTargetEnumOptions.add("P");
		ThrustPIDScaleTargetEnumOptions.add("I");
		ThrustPIDScaleTargetEnumOptions.add("D");
		fields.add( new UAVObjectField("ThrustPIDScaleTarget", "", UAVObjectField.FieldType.ENUM, ThrustPIDScaleTargetElemNames, ThrustPIDScaleTargetEnumOptions) );

		List<String> ThrustPIDScaleAxesElemNames = new ArrayList<String>();
		ThrustPIDScaleAxesElemNames.add("0");
		List<String> ThrustPIDScaleAxesEnumOptions = new ArrayList<String>();
		ThrustPIDScaleAxesEnumOptions.add("Roll Pitch Yaw");
		ThrustPIDScaleAxesEnumOptions.add("Roll Pitch");
		ThrustPIDScaleAxesEnumOptions.add("Roll Yaw");
		ThrustPIDScaleAxesEnumOptions.add("Roll");
		ThrustPIDScaleAxesEnumOptions.add("Pitch Yaw");
		ThrustPIDScaleAxesEnumOptions.add("Pitch");
		ThrustPIDScaleAxesEnumOptions.add("Yaw");
		fields.add( new UAVObjectField("ThrustPIDScaleAxes", "", UAVObjectField.FieldType.ENUM, ThrustPIDScaleAxesElemNames, ThrustPIDScaleAxesEnumOptions) );


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
		getField("RollRatePID").setValue(0.003,0);
		getField("RollRatePID").setValue(0.0065,1);
		getField("RollRatePID").setValue(3.3e-05,2);
		getField("RollRatePID").setValue(0.3,3);
		getField("PitchRatePID").setValue(0.003,0);
		getField("PitchRatePID").setValue(0.0065,1);
		getField("PitchRatePID").setValue(3.3e-05,2);
		getField("PitchRatePID").setValue(0.3,3);
		getField("YawRatePID").setValue(0.0062,0);
		getField("YawRatePID").setValue(0.01,1);
		getField("YawRatePID").setValue(5e-05,2);
		getField("YawRatePID").setValue(0.3,3);
		getField("RollPI").setValue(2.5,0);
		getField("RollPI").setValue(0,1);
		getField("RollPI").setValue(50,2);
		getField("PitchPI").setValue(2.5,0);
		getField("PitchPI").setValue(0,1);
		getField("PitchPI").setValue(50,2);
		getField("YawPI").setValue(2.5,0);
		getField("YawPI").setValue(0,1);
		getField("YawPI").setValue(50,2);
		getField("ManualRate").setValue(220,0);
		getField("ManualRate").setValue(220,1);
		getField("ManualRate").setValue(220,2);
		getField("MaximumRate").setValue(300,0);
		getField("MaximumRate").setValue(300,1);
		getField("MaximumRate").setValue(300,2);
		getField("RollMax").setValue(55);
		getField("PitchMax").setValue(55);
		getField("YawMax").setValue(35);
		getField("StickExpo").setValue(0,0);
		getField("StickExpo").setValue(0,1);
		getField("StickExpo").setValue(0,2);
		getField("AcroInsanityFactor").setValue(40,0);
		getField("AcroInsanityFactor").setValue(40,1);
		getField("AcroInsanityFactor").setValue(40,2);
		getField("EnablePiroComp").setValue("True");
		getField("FpvCamTiltCompensation").setValue(0);
		getField("EnableThrustPIDScaling").setValue("False");
		getField("ThrustPIDScaleCurve").setValue(30,0);
		getField("ThrustPIDScaleCurve").setValue(15,1);
		getField("ThrustPIDScaleCurve").setValue(0,2);
		getField("ThrustPIDScaleCurve").setValue(-15,3);
		getField("ThrustPIDScaleCurve").setValue(-30,4);
		getField("ThrustPIDScaleSource").setValue("ActuatorDesiredThrust");
		getField("ThrustPIDScaleTarget").setValue("PID");
		getField("ThrustPIDScaleAxes").setValue("Roll Pitch");

	}

	/**
	 * Create a clone of this object, a new instance ID must be specified.
	 * Do not use this function directly to create new instances, the
	 * UAVObjectManager should be used instead.
	 */
	public UAVDataObject clone(long instID) {
		// TODO: Need to get specific instance to clone
		try {
			StabilizationSettingsBank3 obj = new StabilizationSettingsBank3();
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
		return new StabilizationSettingsBank3();
	}

	/**
	 * Static function to retrieve an instance of the object.
	 */
	public StabilizationSettingsBank3 GetInstance(UAVObjectManager objMngr, long instID)
	{
	    return (StabilizationSettingsBank3)(objMngr.getObject(StabilizationSettingsBank3.OBJID, instID));
	}

	// Constants
	protected static final long OBJID = 0x5C80D844l;
	protected static final String NAME = "StabilizationSettingsBank3";
	protected static String DESCRIPTION = "Currently selected PID bank";
	protected static final boolean ISSINGLEINST = 1 > 0;
	protected static final boolean ISSETTINGS = 1 > 0;
	protected static int NUMBYTES = 0;


}
