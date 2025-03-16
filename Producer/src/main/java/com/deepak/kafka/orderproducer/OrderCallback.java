 package com.deepak.kafka.orderproducer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class OrderCallback implements Callback {

	@Override
	public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
		System.out.println("Message sent successfully!");
		System.out.println("Partition:: "+recordMetadata.partition());
		System.out.println("Offset:: "+recordMetadata.offset());
		System.out.println("Topic:: "+recordMetadata.topic());
		System.out.println("TimeStamp:: "+recordMetadata.timestamp());
		if(exception != null) {
			exception.printStackTrace();
		}

	}

}
