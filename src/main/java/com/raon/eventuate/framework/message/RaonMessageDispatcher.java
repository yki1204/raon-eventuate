package com.raon.eventuate.framework.message;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.tram.messaging.consumer.MessageConsumer;
import io.eventuate.tram.messaging.consumer.MessageHandler;

public class RaonMessageDispatcher {
	
	private final String subscriberId;
	private String channel;
	private MessageHandler handler;
	
	@Autowired
	private MessageConsumer messageConsumer;

	public RaonMessageDispatcher(String subscriberId, String channel, MessageHandler handler) {
		this.subscriberId = subscriberId;
		this.channel = channel;
		this.handler = handler;
	}
	
	@PostConstruct
	public void initialize() {
		messageConsumer.subscribe(subscriberId, Collections.singleton(channel), handler);
	}
	
}
