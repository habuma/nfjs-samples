package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeaBooksGoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeaBooksGoodApplication.class, args);
	}

	@Bean
	public CommandLineRunner startup() {
		return args -> {
			System.out.println("HELLO!");
		};
	}
	
}
