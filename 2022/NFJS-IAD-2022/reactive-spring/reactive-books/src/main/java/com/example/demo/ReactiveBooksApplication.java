package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBooksApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner loader(BookRepository repo) {
		return args -> {
			System.out.println("SAVING BOOK 1");
			repo.save(new Book(
					"1111122222", 
					"Knitting with Dog Hair", 
					"Kendall Crolius"))
				.subscribe();			
			System.out.println("SAVING BOOK 2");
			repo.save(new Book(
					"3333344444", 
					"Crafting with Cat Hair", 
					"Kaori Tsutaya"))
				.subscribe();		
			repo.save(new Book(
					"4444455555", 
					"Spring in Action", 
					"Craig Walls"))
				.subscribe();		
			repo.save(new Book(
					"5555566666", 
					"Spring Boot in Action", 
					"Craig Walls"))
				.subscribe();		
			repo.save(new Book(
					"6666677777", 
					"Build Talking Apps", 
					"Craig Walls"))
				.subscribe();		
			repo.save(new Book(
					"7777788888", 
					"Reactive Spring", 
					"Josh Long"))
				.subscribe();
			System.out.println("SAVING BOOKS COMPLETE");
		};
	}

}
