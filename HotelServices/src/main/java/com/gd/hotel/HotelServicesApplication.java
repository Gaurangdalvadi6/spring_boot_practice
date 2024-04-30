package com.gd.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HotelServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServicesApplication.class, args);
	}

}
