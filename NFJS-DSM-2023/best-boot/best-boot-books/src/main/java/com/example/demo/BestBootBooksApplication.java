package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BestBootBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestBootBooksApplication.class, args);
	}
	
	@Bean
	ApplicationRunner loader(BookRepository repo) {
		return args -> {
			repo.save(new Book(null, "1122334455", "Knitting with Dog Hair", "Kendall Crolius")).subscribe();
		};
	}

}
