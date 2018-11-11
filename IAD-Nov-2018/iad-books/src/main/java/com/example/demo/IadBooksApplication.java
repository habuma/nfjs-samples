package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IadBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(IadBooksApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book(null, "1234567890", "Knitting with Dog Hair", "Kendall", "Crolius"));
			repo.save(new Book(null, "9876543210", "Crafting with Cat Hair", "Kaori", "Tsutaya"));		};
	}

}
