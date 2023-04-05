package com.genspark.OM_ProductMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OmProductMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmProductMicroserviceApplication.class, args);
	}

}
