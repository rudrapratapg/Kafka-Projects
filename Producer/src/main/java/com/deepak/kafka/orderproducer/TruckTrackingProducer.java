package com.deepak.kafka.orderproducer;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TruckTrackingProducer {
	
	public static void checkIfTopicExist(Properties props, String topicName) {
		AdminClient adminClient = AdminClient.create(props);
		ListTopicsResult topicsResult = adminClient.listTopics();
		boolean isTopicExist = false;
		Set<String> topics;
		try {
			topics = topicsResult.names().get();
			if(topics.contains(topicName)) {
				System.out.println("Topic '"+topicName+"' exists");
				isTopicExist = true;
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		if(isTopicExist == false) {
			System.out.println("Topic '"+topicName+"' does not exist");
		}
	}

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers","localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		String topicName = "TruckTracking";
		
//		key = uniqueID | value= coordinates { latitude , longitude}}
		KafkaProducer<Integer, String> producer = new KafkaProducer<>(props);
		ProducerRecord<Integer, String> record1 = new ProducerRecord<Integer, String>(topicName, 1, "28.7041 N,77.1025 E");
		ProducerRecord<Integer, String> record2 = new ProducerRecord<Integer, String>(topicName, 2, "23.7041 N,67.1025 E");
		ProducerRecord<Integer, String> record3 = new ProducerRecord<Integer, String>(topicName, 3, "26.7041 N,47.1025 E");
		ProducerRecord<Integer, String> record4 = new ProducerRecord<Integer, String>(topicName, 4, "27.7041 N,57.1025 E");
		ProducerRecord<Integer, String> record5 = new ProducerRecord<Integer, String>(topicName, 5, "25.7041 N,17.1025 E");
		
		List<ProducerRecord<Integer, String>> records = Arrays.asList(record1, record2, record3, record4, record5);
		
		try {
			checkIfTopicExist(props, topicName);
			for(ProducerRecord<Integer, String> record : records) {
//				Future<RecordMetadata> future = producer.send(record);
//				RecordMetadata metadata = future.get();
//				System.out.println("Record sent to partition: " + metadata.partition() + ", offset: " + metadata.offset());
				System.out.println("Firing send method");
				producer.send(record, new TruckTrackingCallback());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}

	}

}
