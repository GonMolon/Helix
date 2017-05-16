/**
 ******************************************************************************
 *
 * @file       GPSSettings.java
 * @author     The OpenPilot Team, http://www.openpilot.org Copyright (C) 2010.
 * @brief      Template for an uavobject in java
 *             This is a autogenerated file!! Do not modify and expect a result.
 *             GPS Module specific settings
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
GPS Module specific settings

generated from gpssettings.xml
 **/
public class GPSSettings extends UAVDataObject {

	public GPSSettings() {
		super(OBJID, ISSINGLEINST, ISSETTINGS, NAME);
		
		List<UAVObjectField> fields = new ArrayList<UAVObjectField>();
		

		List<String> MaxPDOPElemNames = new ArrayList<String>();
		MaxPDOPElemNames.add("0");
		fields.add( new UAVObjectField("MaxPDOP", "", UAVObjectField.FieldType.FLOAT32, MaxPDOPElemNames, null) );

		List<String> DataProtocolElemNames = new ArrayList<String>();
		DataProtocolElemNames.add("0");
		List<String> DataProtocolEnumOptions = new ArrayList<String>();
		DataProtocolEnumOptions.add("NMEA");
		DataProtocolEnumOptions.add("UBX");
		DataProtocolEnumOptions.add("DJI");
		fields.add( new UAVObjectField("DataProtocol", "", UAVObjectField.FieldType.ENUM, DataProtocolElemNames, DataProtocolEnumOptions) );

		List<String> MinSatellitesElemNames = new ArrayList<String>();
		MinSatellitesElemNames.add("0");
		fields.add( new UAVObjectField("MinSatellites", "", UAVObjectField.FieldType.UINT8, MinSatellitesElemNames, null) );

		List<String> UbxAutoConfigElemNames = new ArrayList<String>();
		UbxAutoConfigElemNames.add("0");
		List<String> UbxAutoConfigEnumOptions = new ArrayList<String>();
		UbxAutoConfigEnumOptions.add("Disabled");
		UbxAutoConfigEnumOptions.add("AutoBaud");
		UbxAutoConfigEnumOptions.add("AutoBaudAndConfigure");
		UbxAutoConfigEnumOptions.add("AutoBaudConfigureAndStore");
		UbxAutoConfigEnumOptions.add("AutoBaudConfigureStoreAndDisable");
		fields.add( new UAVObjectField("UbxAutoConfig", "", UAVObjectField.FieldType.ENUM, UbxAutoConfigElemNames, UbxAutoConfigEnumOptions) );

		List<String> UbxRateElemNames = new ArrayList<String>();
		UbxRateElemNames.add("0");
		fields.add( new UAVObjectField("UbxRate", "Hz", UAVObjectField.FieldType.INT8, UbxRateElemNames, null) );

		List<String> UbxDynamicModelElemNames = new ArrayList<String>();
		UbxDynamicModelElemNames.add("0");
		List<String> UbxDynamicModelEnumOptions = new ArrayList<String>();
		UbxDynamicModelEnumOptions.add("Portable");
		UbxDynamicModelEnumOptions.add("Stationary");
		UbxDynamicModelEnumOptions.add("Pedestrian");
		UbxDynamicModelEnumOptions.add("Automotive");
		UbxDynamicModelEnumOptions.add("Sea");
		UbxDynamicModelEnumOptions.add("Airborne1G");
		UbxDynamicModelEnumOptions.add("Airborne2G");
		UbxDynamicModelEnumOptions.add("Airborne4G");
		fields.add( new UAVObjectField("UbxDynamicModel", "", UAVObjectField.FieldType.ENUM, UbxDynamicModelElemNames, UbxDynamicModelEnumOptions) );

		List<String> UbxSBASModeElemNames = new ArrayList<String>();
		UbxSBASModeElemNames.add("0");
		List<String> UbxSBASModeEnumOptions = new ArrayList<String>();
		UbxSBASModeEnumOptions.add("Disabled");
		UbxSBASModeEnumOptions.add("Ranging");
		UbxSBASModeEnumOptions.add("Correction");
		UbxSBASModeEnumOptions.add("Integrity");
		UbxSBASModeEnumOptions.add("Ranging+Correction");
		UbxSBASModeEnumOptions.add("Ranging+Integrity");
		UbxSBASModeEnumOptions.add("Ranging+Correction+Integrity");
		UbxSBASModeEnumOptions.add("Correction+Integrity");
		fields.add( new UAVObjectField("UbxSBASMode", "", UAVObjectField.FieldType.ENUM, UbxSBASModeElemNames, UbxSBASModeEnumOptions) );

		List<String> UbxSBASChannelsUsedElemNames = new ArrayList<String>();
		UbxSBASChannelsUsedElemNames.add("0");
		fields.add( new UAVObjectField("UbxSBASChannelsUsed", "", UAVObjectField.FieldType.UINT8, UbxSBASChannelsUsedElemNames, null) );

		List<String> UbxSBASSatsElemNames = new ArrayList<String>();
		UbxSBASSatsElemNames.add("0");
		List<String> UbxSBASSatsEnumOptions = new ArrayList<String>();
		UbxSBASSatsEnumOptions.add("AutoScan");
		UbxSBASSatsEnumOptions.add("WAAS");
		UbxSBASSatsEnumOptions.add("EGNOS");
		UbxSBASSatsEnumOptions.add("MSAS");
		UbxSBASSatsEnumOptions.add("GAGAN");
		UbxSBASSatsEnumOptions.add("SDCM");
		fields.add( new UAVObjectField("UbxSBASSats", "", UAVObjectField.FieldType.ENUM, UbxSBASSatsElemNames, UbxSBASSatsEnumOptions) );

		List<String> UbxGNSSModeElemNames = new ArrayList<String>();
		UbxGNSSModeElemNames.add("0");
		List<String> UbxGNSSModeEnumOptions = new ArrayList<String>();
		UbxGNSSModeEnumOptions.add("Default");
		UbxGNSSModeEnumOptions.add("GPS");
		UbxGNSSModeEnumOptions.add("GLONASS");
		UbxGNSSModeEnumOptions.add("GPS+GLONASS");
		UbxGNSSModeEnumOptions.add("GPS+BeiDou");
		UbxGNSSModeEnumOptions.add("GLONASS+BeiDou");
		UbxGNSSModeEnumOptions.add("GPS+GALILEO");
		UbxGNSSModeEnumOptions.add("GPS+GLONASS+GALILEO");
		fields.add( new UAVObjectField("UbxGNSSMode", "", UAVObjectField.FieldType.ENUM, UbxGNSSModeElemNames, UbxGNSSModeEnumOptions) );

		List<String> UbxAssistNowAutonomousElemNames = new ArrayList<String>();
		UbxAssistNowAutonomousElemNames.add("0");
		List<String> UbxAssistNowAutonomousEnumOptions = new ArrayList<String>();
		UbxAssistNowAutonomousEnumOptions.add("False");
		UbxAssistNowAutonomousEnumOptions.add("True");
		fields.add( new UAVObjectField("UbxAssistNowAutonomous", "", UAVObjectField.FieldType.ENUM, UbxAssistNowAutonomousElemNames, UbxAssistNowAutonomousEnumOptions) );


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
		getField("MaxPDOP").setValue(3.5);
		getField("DataProtocol").setValue("UBX");
		getField("MinSatellites").setValue(7);
		getField("UbxAutoConfig").setValue("AutoBaudAndConfigure");
		getField("UbxRate").setValue(5);
		getField("UbxDynamicModel").setValue("Airborne1G");
		getField("UbxSBASMode").setValue("Ranging");
		getField("UbxSBASChannelsUsed").setValue(3);
		getField("UbxSBASSats").setValue("AutoScan");
		getField("UbxGNSSMode").setValue("Default");
		getField("UbxAssistNowAutonomous").setValue("True");

	}

	/**
	 * Create a clone of this object, a new instance ID must be specified.
	 * Do not use this function directly to create new instances, the
	 * UAVObjectManager should be used instead.
	 */
	public UAVDataObject clone(long instID) {
		// TODO: Need to get specific instance to clone
		try {
			GPSSettings obj = new GPSSettings();
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
		return new GPSSettings();
	}

	/**
	 * Static function to retrieve an instance of the object.
	 */
	public GPSSettings GetInstance(UAVObjectManager objMngr, long instID)
	{
	    return (GPSSettings)(objMngr.getObject(GPSSettings.OBJID, instID));
	}

	// Constants
	protected static final long OBJID = 0xF300A164l;
	protected static final String NAME = "GPSSettings";
	protected static String DESCRIPTION = "GPS Module specific settings";
	protected static final boolean ISSINGLEINST = 1 > 0;
	protected static final boolean ISSETTINGS = 1 > 0;
	protected static int NUMBYTES = 0;


}
