package com.example.securebooks2;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecureBooks2Application {

  public static void main(String[] args) {
    SpringApplication.run(SecureBooks2Application.class, args);
  }

  @Bean
  ApplicationRunner init(BookRepository bookRepository) {
    return args -> {
      bookRepository.save(new Book(null, "1122334455", "Spring in Action", "Craig Walls", "venkat"));
      bookRepository.save(new Book(null, "5544332211", "Moby Dick", "Herman Melville", "habuma"));
    };
  }

}
