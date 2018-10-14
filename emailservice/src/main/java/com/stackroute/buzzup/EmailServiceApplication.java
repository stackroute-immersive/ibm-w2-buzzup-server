package com.stackroute.buzzup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.satckroute.buzzup","com.stackroute.buzzup.config","com.satckroute.buzzup.controller","com.stackroute.buzzup.model","com.stackroute.buzzup.rsvep.domain","com.stackroute.buzzup.service"})
@SpringBootApplication
@EnableEurekaClient
public class EmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}
}
