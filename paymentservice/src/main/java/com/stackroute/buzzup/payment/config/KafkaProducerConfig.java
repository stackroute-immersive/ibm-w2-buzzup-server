package com.stackroute.buzzup.payment.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.stackroute.buzzup.kafka.domain.TicketDetails;

@Configuration
public class KafkaProducerConfig {

	
	// Declaring Topic
	static final String TOPIC = "payment";

	// 192.168.43.174 172.23.239.111
	// KafkaProducerConfig factory of kafka which will hold the configuration
	// details
	@Bean
	public ProducerFactory<String, TicketDetails> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(config);
	}

	// Template imports the configuration from producerfactory
	@Bean
	public KafkaTemplate<String, TicketDetails> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	// To Send Topic
	public static String getTopic() {
		return TOPIC;
	}

}
