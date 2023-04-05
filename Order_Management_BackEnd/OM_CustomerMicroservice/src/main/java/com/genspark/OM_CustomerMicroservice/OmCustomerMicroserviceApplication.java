package com.genspark.OM_CustomerMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OmCustomerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmCustomerMicroserviceApplication.class, args);
	}

}
