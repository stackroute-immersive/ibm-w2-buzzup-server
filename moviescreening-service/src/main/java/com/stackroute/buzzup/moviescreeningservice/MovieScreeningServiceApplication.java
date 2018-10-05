package com.stackroute.buzzup.moviescreeningservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages="com.stackroute.buzzup.*")
public class MovieScreeningServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MovieScreeningServiceApplication.class, args);
	}
}
