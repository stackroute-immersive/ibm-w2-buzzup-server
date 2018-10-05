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

import com.stackroute.buzzup.kafka.model.MovieSchedule;

/*
 * this is the configuration for kafka producer
 * Contains configuration for kafka
 */
@Configuration
public class KafkaProducerConfig {

/*	@Value("${bootstrap-id}")*/

	// Declaring Topic
	private static final String TOPIC = "screening-details1";
	private static final String TOPIC1 = "screenings";
	private static final String TOPIC2 = "screening-schedule";
	private static final String TOPIC3 = "screening-ticket";

	@Bean
	public ProducerFactory<String, MovieSchedule> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
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
