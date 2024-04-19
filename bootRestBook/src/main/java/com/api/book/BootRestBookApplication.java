package com.api.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootRestBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestBookApplication.class, args);
		System.out.println("This is spring boot...");
	}

}
