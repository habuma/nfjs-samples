package com.habuma.booksgraphql;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.GraphQlClient;

@SpringBootApplication
public class BooksGraphqlApplication {

  public static void main(String[] args) {
    SpringApplication.run(BooksGraphqlApplication.class, args);
  }

  @Bean
  ApplicationRunner go(BookRepository bookRepository) {
    return args -> {
      bookRepository.save(new Book("1122334455", "Knitting with Dog Hair", new Author("Kendall", "Crolius")));
      bookRepository.save(new Book("5544332211", "Crafting with Cat Hair", new Author("Kaori", "Tsutaya")));
    };
  }

}
