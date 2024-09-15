package com.habuma.springbooks;

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
      bookRepository.save(new Book(null, "1122334455", "To Kill a Mockingbird", "Harper Lee"));
      bookRepository.save(new Book(null, "2233445566", "1984", "George Orwell"));
      bookRepository.save(new Book(null, "3344556677", "The Hobbit", "J.R.R. Tolkien"));
      bookRepository.save(new Book(null, "4455667788", "Dune", "Frank Herbert"));
      bookRepository.save(new Book(null, "5566778899", "The Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
    };
  }

}
