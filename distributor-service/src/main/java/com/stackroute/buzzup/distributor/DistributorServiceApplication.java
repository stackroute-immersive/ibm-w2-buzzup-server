package com.stackroute.buzzup.distributor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DistributorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributorServiceApplication.class, args);
	}
}
