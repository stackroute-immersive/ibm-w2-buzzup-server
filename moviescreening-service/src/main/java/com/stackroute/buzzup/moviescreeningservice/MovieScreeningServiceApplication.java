package com.stackroute.buzzup.moviescreeningservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieScreeningServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieScreeningServiceApplication.class, args);
	}
}
