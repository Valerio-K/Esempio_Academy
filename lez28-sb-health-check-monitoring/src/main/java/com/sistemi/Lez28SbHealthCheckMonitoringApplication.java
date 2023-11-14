package com.sistemi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Lez28SbHealthCheckMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lez28SbHealthCheckMonitoringApplication.class, args);
	}

}
