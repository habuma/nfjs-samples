package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlakyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlakyApiApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book("1111122222", "Knitting with Dog Hair", "Kendall Crolius"));
			repo.save(new Book("2222233333", "Crafting with Cat Hair", "Kaori Tsutaya"));		
		};
	}
	
}
