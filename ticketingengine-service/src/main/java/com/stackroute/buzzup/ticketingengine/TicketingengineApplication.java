package com.stackroute.buzzup.ticketingengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class TicketingengineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingengineApplication.class, args);
	}
}
