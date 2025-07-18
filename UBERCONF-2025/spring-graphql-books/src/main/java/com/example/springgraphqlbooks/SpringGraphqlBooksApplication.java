package com.example.springgraphqlbooks;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGraphqlBooksApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringGraphqlBooksApplication.class, args);
  }

  @Bean
  ApplicationRunner init(BookRepository bookRepo, AuthorRepository authorRepo) {
    return args -> {

      var kendall = authorRepo.save(new Author("Kendall", "Crolius"));
      var kaori = authorRepo.save(new Author("Kaori", "Tsutaya"));

      bookRepo.save(new Book("1122334455", "Knitting with Dog Hair", kendall));
      bookRepo.save(new Book("5544332211", "Crafting with Cat Hair", kaori));

    };
  }

}
