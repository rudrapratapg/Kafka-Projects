package com.deepak.kafka.orderconsumer.customdeserializers;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TruckTrackingDeserializer implements Deserializer<TruckTracking> {

	@Override
	public TruckTracking deserialize(String topic, byte[] data) {
		TruckTracking truckTracking = null;
		ObjectMapper mappper = new ObjectMapper();
		try {
			truckTracking = mappper.readValue(data, TruckTracking.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return truckTracking;
	}

}
