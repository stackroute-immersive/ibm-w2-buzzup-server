package com.stackroute.buzzup.schedularservice.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.kafka.model.TriggerMessage;
import com.stackroute.buzzup.schedularservice.config.KafkaProducer;

@Service
//Job class
public class JobFunction implements Job { 

	public static String NAME;
	public static String SLOT;
	public static String CITY;

	private static KafkaTemplate<String, TriggerMessage> objectKafkaTemplate;
	private static KafkaTemplate<String, String> kafkaTemplate;

	public JobFunction() {
	}

	//autowiring the Kafka Template
	@Autowired
	public JobFunction(KafkaTemplate<String, String> kafkaTemplate,
			KafkaTemplate<String, TriggerMessage> objectKafkaTemplate) {
		if (JobFunction.kafkaTemplate == null) {
			JobFunction.kafkaTemplate = kafkaTemplate;
		}
		if (JobFunction.objectKafkaTemplate == null) {
			JobFunction.objectKafkaTemplate = objectKafkaTemplate;
		}
	}

	@Override
	//this "execute" method is invoked when the Trigger fires.
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//Job Data Map is used to provide properties/configuration for job instance.
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		//getting details of job.
		String name = dataMap.getString("theatreName");
		String slot = dataMap.getString("slot");
		String city = dataMap.getString("city");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String dateString = dateFormat.format(date);
		System.out.println(dateString);
		//Creating new object of TriggerMessage Class
		TriggerMessage message = new TriggerMessage(name, dateString, slot, city);
		//String messageStr = message.toString();
		String topic = KafkaProducer.TOPIC;
		
		//Publishing the object of TriggerMessage to the Kafka topic
		objectKafkaTemplate.send(topic, message);
	}
}
