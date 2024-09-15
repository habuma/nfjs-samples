package com.habuma.springbooksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class SpringBooksClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBooksClientApplication.class, args);
  }

  @Bean
  ApplicationRunner go(RestClient.Builder restClientBuilder) {
    return args -> {
      System.out.println("Hello, Spring Books Client!");

      RestClient restClient = restClientBuilder.baseUrl("http://localhost:8080")
          .build();

      Book[] book = restClient.get()
          .uri("/books")
          .header("X_MY_HEADER", "My Value")
          .retrieve()
          .body(Book[].class);

      for (Book b : book) {
        System.out.println(b);
      }

    };
  }

}
