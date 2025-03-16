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

import com.deepak.kafka.orderproducer.customserializers.TruckTracking;

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
		props.setProperty("value.serializer", "com.deepak.kafka.orderproducer.customserializers.TruckTrackingSerializer");
		
		String topicName = "TruckTracking";
		
//		key = uniqueID | value= coordinates { latitude , longitude}}
		KafkaProducer<Integer, TruckTracking> producer = new KafkaProducer<>(props);
		TruckTracking truck1 = new TruckTracking.Builder().setUniqueId(1).setLongitude("28.7041 N").setLatitude("77.1025 E").build(); 
		ProducerRecord<Integer, TruckTracking> record1 = new ProducerRecord<>(topicName, 1, truck1);
		
		TruckTracking truck2 = new TruckTracking.Builder().setUniqueId(2).setLongitude("23.7041 N").setLatitude("67.1025 E").build();
		ProducerRecord<Integer, TruckTracking> record2 = new ProducerRecord<>(topicName, 2, truck2);
		
		TruckTracking truck3 = new TruckTracking.Builder().setUniqueId(3).setLongitude("26.7041 N").setLatitude("47.1025 E").build();
		ProducerRecord<Integer, TruckTracking> record3 = new ProducerRecord<>(topicName, 3, truck3);
		
		TruckTracking truck4 = new TruckTracking.Builder().setUniqueId(4).setLongitude("27.7041 N").setLatitude("57.1025 E").build();
		ProducerRecord<Integer, TruckTracking> record4 = new ProducerRecord<>(topicName, 4, truck4);
		
		TruckTracking truck5 = new TruckTracking.Builder().setUniqueId(5).setLongitude("25.7041 N").setLatitude("17.1025 E").build();
		ProducerRecord<Integer, TruckTracking> record5 = new ProducerRecord<>(topicName, 5, truck5);
		
		List<ProducerRecord<Integer, TruckTracking>> records = Arrays.asList(record1, record2, record3, record4, record5);
		
		try {
//			checkIfTopicExist(props, topicName);
			for(ProducerRecord<Integer, TruckTracking> record : records) {
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
