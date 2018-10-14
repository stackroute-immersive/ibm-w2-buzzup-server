package com.stackroute.buzzup.moviescreeningservice.config;

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

import com.stackroute.buzzup.kafka.domain.MovieSchedule;


@Configuration
public class KafkaProducerConfig {
	
	
	static final String TOPIC = "screening-details";
	static final String TOPIC1 = "screenings";
	static final String TOPIC2 = "screening-schedule";
	static final String TOPIC3 = "screening-ticket";

	
	@Bean
	public ProducerFactory<String, MovieSchedule> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(config);
	}

	
	@Bean
	public KafkaTemplate<String, MovieSchedule> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	
	public static String getTopic() {
		return TOPIC;
	}

	
	public static String getTopic1() {
		return TOPIC1;
	}

	public static String getTopic2() {
		return TOPIC2;
	}

	public static String getTopic3() {
		return TOPIC3;
	}

}
