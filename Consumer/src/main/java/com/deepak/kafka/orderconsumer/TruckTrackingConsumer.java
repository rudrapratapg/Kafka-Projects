package com.deepak.kafka.orderconsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class TruckTrackingConsumer {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers","localhost:9092");
		props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
		props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("group.id", "TruckTrackingGroup");
		
		KafkaConsumer<Integer, String> consumer = new KafkaConsumer<>(props);
		
		String topicName = "TruckTracking";
		try {
			consumer.subscribe(Collections.singletonList(topicName));
			ConsumerRecords<Integer, String> records = consumer.poll(Duration.ofSeconds(20));
			records.forEach( record -> {
				System.out.println("Truck ID:: "+record.key()+" Coordinates:: "+record.value());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		consumer.close();

	}

}
