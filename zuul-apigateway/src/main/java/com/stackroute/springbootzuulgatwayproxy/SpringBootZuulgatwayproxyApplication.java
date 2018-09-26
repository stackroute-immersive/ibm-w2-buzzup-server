package com.stackroute.springbootzuulgatwayproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.stackroute.springbootzuulgatwayproxy.filters.ErrorFilter;
import com.stackroute.springbootzuulgatwayproxy.filters.PostFilter;
import com.stackroute.springbootzuulgatwayproxy.filters.PreFilter;
import com.stackroute.springbootzuulgatwayproxy.filters.RouteFilter;

@SpringBootApplication
@EnableDiscoveryClient  // for eureka server to find this application
@EnableZuulProxy // to act as api-gateway
public class SpringBootZuulgatwayproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZuulgatwayproxyApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
