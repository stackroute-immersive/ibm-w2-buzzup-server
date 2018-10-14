package com.stackroute.buzzup.schedularservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableEurekaClient
public class SchedularServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedularServiceApplication.class, args);
	}
}
