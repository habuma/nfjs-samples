package com.example.graphbooks;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphBooksApplication {

  public static void main(String[] args) {
    SpringApplication.run(GraphBooksApplication.class, args);
  }

  @Bean
  ApplicationRunner go(BookRepository bookRepo, AuthorRepository authorRepo) {
    return args -> {
      Author kendall = authorRepo.save(new Author("Kendall", "Crolius"));
      Author kaori = authorRepo.save(new Author("Kaori", "Tsutaya"));
      bookRepo.save(new Book("1122334455", "Knitting with Dog Hair", kendall));
      bookRepo.save(new Book("5544332211", "Crafting with Cat Hair", kaori));
    };
  }

}
