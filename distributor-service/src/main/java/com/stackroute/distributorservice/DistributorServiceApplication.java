package com.stackroute.distributorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class DistributorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributorServiceApplication.class, args);
	}
}
