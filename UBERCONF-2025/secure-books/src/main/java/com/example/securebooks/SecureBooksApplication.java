package com.example.securebooks;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecureBooksApplication {

  public static void main(String[] args) {
    SpringApplication.run(SecureBooksApplication.class, args);
  }

  @Bean
  ApplicationRunner init(BookRepository bookRepository) {
    return args -> {
      bookRepository.save(new Book(null, "1122334455", "Knitting with Dog Hair", "Kendall Crolius", "izzy"));
      bookRepository.save(new Book(null, "5544332211", "Crafting with Cat Hair", "Kaori Tsutaya", "habuma"));
    };
  }

}
