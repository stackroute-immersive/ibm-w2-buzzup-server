package com.stackroute.buzzup.ticketengine.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.buzzup.kafka.domain.MovieSchedule;
import com.stackroute.buzzup.kafka.domain.TicketDetails;
import com.stackroute.buzzup.kafka.domain.TriggerMessage;

@EnableKafka
@Configuration
public class KafkaConsumer {

	// @Value("${bootstrap-id}")
	// private String bootstrap_id;

	@Bean
	public ConsumerFactory<String, MovieSchedule> consumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.20.1.16:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "ticket");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(MovieSchedule.class));
	}

	public ConsumerFactory<String, TicketDetails> payConsumerFactory() {
		Map<String, Object> payConfig = new HashMap<>();
		payConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.20.1.16:9092");
		payConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "pay");
		payConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		payConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(payConfig, new StringDeserializer(),
				new JsonDeserializer<>(TicketDetails.class));
	}

	public ConsumerFactory<String, TriggerMessage> schedulerConsumerFactory() {
		Map<String, Object> schedulerConfig = new HashMap<>();
		schedulerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.20.1.16:9092");
		schedulerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "schedule");
		schedulerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		schedulerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(schedulerConfig, new StringDeserializer(),
				new JsonDeserializer<>(TriggerMessage.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MovieSchedule> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, MovieSchedule> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;

	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TicketDetails> payKafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, TicketDetails> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(payConsumerFactory());
		return factory;

	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TriggerMessage> schedulerKafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, TriggerMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(schedulerConsumerFactory());
		return factory;

	}

}
