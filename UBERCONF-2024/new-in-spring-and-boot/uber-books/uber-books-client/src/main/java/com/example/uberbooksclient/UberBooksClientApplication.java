package com.example.uberbooksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

@SpringBootApplication
public class UberBooksClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(UberBooksClientApplication.class, args);
  }

  @Bean
  RestClient restClient(RestClient.Builder builder) {
    return builder
        .baseUrl("http://localhost:8080")
        .defaultHeader("X-SOME_HEADER", "some_value")
        .build();
  }


  @Bean
  ApplicationRunner go(RestClient restClient, BookClient bookClient) {
    return args -> {
//      List<Book> books = restClient
//          .get()
//          .uri("/books")
//          .retrieve()
//          .body(new ParameterizedTypeReference<List<Book>>() {
//          });
//
//      for(Book book : books) {
//        System.out.println(book);
//      }
//
      Book book = restClient.get()
          .uri("/books/1122334455")
          .retrieve()
          .body(Book.class);

      System.err.println(book);

      System.err.println("===========================================");

      for (Book allBook : bookClient.getAllBooks()) {
        System.err.println("  ==  " + allBook);
      }

      try {
        Book bookByIsbn = bookClient.getBookByIsbn("5544332211");
        System.err.println("   -->  " + bookByIsbn);
      } catch (Exception e) {
        System.err.println("   -->  " + e.getMessage());
      }

    };
  }

}
