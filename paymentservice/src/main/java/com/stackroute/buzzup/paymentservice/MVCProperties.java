package com.stackroute.buzzup.paymentservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class MVCProperties extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		 registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS");
	}

}
