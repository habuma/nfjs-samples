package com.example.springbooks;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBooksApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBooksApplication.class, args);
  }

  @Bean
  ApplicationRunner go(BookRepository bookRepository) {
    return args -> {
      System.out.println("Hello, Spring Books!");

      bookRepository.save(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
      bookRepository.save(new Book("9780451524935", "1984", "George Orwell"));
      bookRepository.save(new Book("9780743273565", "The Great Gatsby", "F. Scott Fitzgerald"));
    };
  }

}
