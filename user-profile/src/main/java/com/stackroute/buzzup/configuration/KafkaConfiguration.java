package com.stackroute.buzzup.configuration;

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

import com.stackroute.buzzup.kafka.model.InputUser;

@Configuration
public class KafkaConfiguration {

	//@Value("${bootstrap-id}")
	//private String bootstrap_id;

	
	static final String TOPIC = "details11";

	
	@Bean
	public ProducerFactory<String, InputUser> producerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(config);
	}

	
	@Bean
	public KafkaTemplate<String, InputUser> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	
	public static String getTopic() {
		return TOPIC;
	}

}
