package com.ironhack.businessmodelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BusinessModelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessModelServiceApplication.class, args);
	}

}
