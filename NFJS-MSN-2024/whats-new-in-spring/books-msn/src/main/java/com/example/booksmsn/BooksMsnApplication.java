package com.example.booksmsn;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksMsnApplication {

  public static void main(String[] args) {
    SpringApplication.run(BooksMsnApplication.class, args);
  }

  @Bean
  ApplicationRunner go(BookRepository bookRepository) {
    return args -> {
      bookRepository.save(new Book("1122334455", "The Catcher in the Rye", "J.D. Salinger"));
      bookRepository.save(new Book("2233445566", "To Kill a Mockingbird", "Harper Lee"));
      bookRepository.save(new Book("3344556677", "1984", "George Orwell"));
    };
  }

}
