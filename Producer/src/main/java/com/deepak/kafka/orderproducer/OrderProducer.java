package com.deepak.kafka.orderproducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class OrderProducer {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers","localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		
		KafkaProducer<String, Integer> producer = new KafkaProducer<>(props);
		ProducerRecord<String, Integer> producerRecord =  new ProducerRecord<String, Integer>("OrderTopic", "MacBook Pro", 10);
		try {
			//Fire and forget
//			producer.send(producerRecord);
			
			//Sync type
//			Future<RecordMetadata> metadataFuture = producer.send(producerRecord);
//			RecordMetadata recordMetadata = metadataFuture.get();
//			System.out.println("Message sent successfully!");
//			System.out.println("Partition:: "+recordMetadata.partition());
//			System.out.println("Offset:: "+recordMetadata.offset());
//			System.out.println("Topic:: "+recordMetadata.topic());
//			System.out.println("TimeStamp:: "+recordMetadata.timestamp());
			
			// Async - on completion callback class will be  will be called, method of this class will be called
			producer.send(producerRecord, new OrderCallback());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
		

	}

}
