package com.stackroute.buzzup.recommendationservice.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.buzzup.kafka.model.InputUser;
import com.stackroute.buzzup.kafka.model.MovieSchedule;


@EnableKafka
@Configuration
public class KafkaConsumerConfig {
//	
//	@Value("${bootstrap-id}")
//	private String bootstrap_id;

	@Bean
	public ConsumerFactory<String, InputUser> consumerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "user");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(InputUser.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, InputUser> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, InputUser> factory = new ConcurrentKafkaListenerContainerFactory<String, InputUser>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	@Bean
	public ConsumerFactory<String, MovieSchedule> movieConsumerFactory() {
		Map<String, Object> movieConfig = new HashMap<>();

		movieConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		movieConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "movie");
		movieConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		movieConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(movieConfig, new StringDeserializer(),
				new JsonDeserializer<>(MovieSchedule.class));
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MovieSchedule> movieKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, MovieSchedule> factory = new ConcurrentKafkaListenerContainerFactory<String, MovieSchedule>();
		factory.setConsumerFactory(movieConsumerFactory());
		return factory;
	}
}
