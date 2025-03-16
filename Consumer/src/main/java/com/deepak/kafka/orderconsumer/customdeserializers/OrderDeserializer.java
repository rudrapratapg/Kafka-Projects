package com.deepak.kafka.orderconsumer.customdeserializers;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderDeserializer implements Deserializer<Order> {

	@Override
	public Order deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = null;
		try {
			order = mapper.readValue(data, Order.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

}
