package com.sistemi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Lez28SbTwitterServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lez28SbTwitterServiceClientApplication.class, args);
	}

}
