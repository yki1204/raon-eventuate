package com.raon.eventuate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.raon.eventuate.framework.message.RaonMessageInterceptor;
import com.raon.eventuate.framework.message.RaonMessageProducer;

import io.eventuate.tram.messaging.producer.MessageProducer;
import io.eventuate.tram.spring.jdbckafka.TramJdbcKafkaConfiguration;

@Configuration
@Import(TramJdbcKafkaConfiguration.class)
public class EventuateCoreAutoConfiguration {
	
	@Bean
	public RaonMessageProducer raonMessageProducer(MessageProducer messageProducer) {
		return new RaonMessageProducer(messageProducer);
	}
	
	@Bean
	public RaonMessageInterceptor raonMessageInterceptor() {
		return new RaonMessageInterceptor();
	}
}
