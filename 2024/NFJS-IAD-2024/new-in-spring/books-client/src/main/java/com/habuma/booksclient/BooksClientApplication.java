package com.habuma.booksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class BooksClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(BooksClientApplication.class, args);
  }

  @Bean
  ApplicationRunner go(RestClient.Builder rcb, BookClient bookClient) {
    return args -> {
      RestClient restClient = rcb.baseUrl("http://localhost:8080").build();

      Book[] books = restClient.get()
          .uri("/books")
          .header("Authorization", "Bearer xxxxxxxx")
          .retrieve()
          .body(Book[].class);

      for (Book book : books) {
        System.out.println(book);
      }

      System.err.println("=====================================");

      Book book = bookClient.getBookByIsbn("1234567890");
      System.err.println(book);

    };
  }

}
