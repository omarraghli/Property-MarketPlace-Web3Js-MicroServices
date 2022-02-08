package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPattern;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan({ "microservice.Controller" })
@ComponentScan({ "microservice.Service" })
@ComponentScan({ "microservice.security" })
@EnableMongoRepositories("microservice.**")
@EnableDiscoveryClient
public class Atest1Application {

	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(Atest1Application.class, args);
	}

}
