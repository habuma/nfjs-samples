package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksQlApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner loader(BookRepository repo, AuthorRepository aRepo) {
		return args -> {
			
			Author kendall = aRepo.save(new Author("Kendall", "Crolius"));
			Author kaori = aRepo.save(new Author("Kaori", "Tsutaya"));

			Book catHair = new Book("1111122222", "Crafting with Cat Hair", kaori);
			Book dogHair = new Book("2222233333", "Knitting with Dog Hair", kendall);
			

			repo.save(catHair);
			repo.save(dogHair);
		};
	}

}
