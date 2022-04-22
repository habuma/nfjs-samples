package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UberBookJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberBookJpaApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book("1234567890", "Knitting with Dog Hair", "Kendall Crolius"));
			repo.save(new Book("9876543210", "Crafting with Cat Hair", "Kaori Tsutaya"));
		};
	}
	
}
