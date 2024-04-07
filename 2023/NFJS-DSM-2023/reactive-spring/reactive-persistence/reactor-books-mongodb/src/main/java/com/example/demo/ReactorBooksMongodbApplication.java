package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactorBooksMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactorBooksMongodbApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner dataLoader(BookRepository repo) {
		return args -> {
			System.out.println("DATA LOADED");
			
			repo.save(new Book(
					null, 
					"1122334455", 
					"Knitting with Dog Hair",
					"Kendall Crolius"))
				.subscribe();
			
			repo.save(new Book(
					null, 
					"5544332211", 
					"Crafting with Cat Hair",
					"Kaori Tsutaya"))
				.subscribe();

		};
	}


}
