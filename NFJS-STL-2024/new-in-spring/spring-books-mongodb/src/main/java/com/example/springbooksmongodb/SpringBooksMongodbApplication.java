package com.example.springbooksmongodb;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBooksMongodbApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBooksMongodbApplication.class, args);
  }

  @Bean
  ApplicationRunner go(BookRepository repo) {
    return args -> {
      repo.save(new Book(null, "9780061120084", "To Kill a Mockingbird", "Harper Lee"));
      repo.save(new Book(null, "9780451524935", "1984", "George Orwell"));
      repo.save(new Book(null, "9780618260300", "The Hobbit", "J.R.R. Tolkien"));
    };
  }

}
