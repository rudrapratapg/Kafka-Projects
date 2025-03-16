package com.deepak.kafka.orderconsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

//import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.deepak.kafka.orderconsumer.customdeserializers.Order;

public class OrderConsumer {
	
	public static void main(String args[]) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers","localhost:9092");
		props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("value.deserializer", "com.deepak.kafka.orderconsumer.customdeserializers.OrderDeserializer");
		props.setProperty("group.id", "OrderGroup");
		
		KafkaConsumer<String, Order> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singletonList("OrderTopic"));
		
		ConsumerRecords<String, Order> orders = consumer.poll(Duration.ofSeconds(20));
		orders.forEach( order -> {
			System.out.println("Product name:: "+order.key()+" Quantity:: "+order.value());
		});
		consumer.close();
		
	}

}
