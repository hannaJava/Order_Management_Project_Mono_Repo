package com.genspark.OM_KafkaConsumerMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableEurekaClient
public class OmKafkaConsumerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmKafkaConsumerMicroserviceApplication.class, args);
	}

}
