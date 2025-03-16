package com.deepak.kafka.orderproducer.customserializers;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TruckTrackingSerializer implements Serializer<TruckTracking> {

	@Override
	public byte[] serialize(String topic, TruckTracking truckTracking) {
		byte[] trackingBytes = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			trackingBytes = mapper.writeValueAsString(truckTracking).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trackingBytes;
	}

	

}
