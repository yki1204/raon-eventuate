package com.raon.eventuate.framework.message;

import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.messaging.producer.MessageBuilder;
import io.eventuate.tram.messaging.producer.MessageProducer;

@Configuration
public class RaonMessageProducer {
	
	private MessageProducer MessageProducer;
	
	public RaonMessageProducer(MessageProducer messageProducer) {
		MessageProducer = messageProducer;
	}

	public void send(String destination, Object message) {
		
		Message toMessage = MessageBuilder.withPayload((new Gson()).toJson(message)).build();
		MessageProducer.send(destination, toMessage);
	}
	
	public void send(String destination, String partitionId, Object message) {
		
		Message toMessage = MessageBuilder.withPayload((new Gson()).toJson(message))
				                          .withHeader(Message.PARTITION_ID, partitionId)
				                          .build();
		
		MessageProducer.send(destination, toMessage);
	}
	
}
