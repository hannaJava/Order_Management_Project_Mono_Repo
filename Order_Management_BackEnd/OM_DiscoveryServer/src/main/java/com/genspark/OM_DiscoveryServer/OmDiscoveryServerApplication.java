package com.genspark.OM_DiscoveryServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OmDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmDiscoveryServerApplication.class, args);
	}

}
