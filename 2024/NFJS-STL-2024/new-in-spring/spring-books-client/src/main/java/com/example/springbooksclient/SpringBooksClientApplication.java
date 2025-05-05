package com.example.springbooksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class SpringBooksClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBooksClientApplication.class, args);
  }

  @Bean
  RestClient restClient(RestClient.Builder restClientBuilder) {
    return restClientBuilder
        .baseUrl("http://localhost:8080")
        .build();
  }

  @Bean
  ApplicationRunner go(RestClient restClient, BookClient bookClient) {
    return args -> {
      System.out.println("Hello, Spring Books Client!");

      Book book = restClient
          .get()
          .uri("/books/{isbn}", "9780451524935")
          .header("My-Header", "My-Value")
          .retrieve()
          .body(Book.class);

      System.err.println("BOOK 1: " + book);

      Book book2 = bookClient.getBook("9780061120084");
      System.err.println("BOOK 2: " + book2);

    };
  }


  @Bean
  HttpServiceProxyFactory httpServiceProxyFactory() {
    RestClient restClient = RestClient.create();
    RestClientAdapter restClientAdapter =
        RestClientAdapter.create(restClient);

    return HttpServiceProxyFactory
        .builderFor(restClientAdapter)
        .build();
  }

  @Bean
  public BookClient bookClient(HttpServiceProxyFactory httpServiceProxyFactory) {
    return httpServiceProxyFactory
        .createClient(BookClient.class);
  }

}
