package com.example.ubergraphbooksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;

@SpringBootApplication
public class UberGraphBooksClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(UberGraphBooksClientApplication.class, args);
  }

  @Bean
  ApplicationRunner go() throws Exception {
    return args -> {
      HttpGraphQlClient graphQL = HttpGraphQlClient.builder()
          .webClient(c -> {
            c.baseUrl("http://localhost:8080/graphql");
          })
          .build();

      graphQL
          .documentName("allBooks")
          .retrieve("allBooks")
          .toEntityList(Book.class)
          .doOnNext(listOfBooks -> {
            listOfBooks.forEach(book -> {
              System.out.println(book);
            });
          })
          .subscribe();

      String query = """
          query ByIsbnQuery($isbn: String!) {
            byIsbn(isbn: $isbn) {
              isbn
              title
            }
          }
          """;


      graphQL
          .document(query)
          .variable("isbn", "1122334455")
              .retrieve("byIsbn")
                  .toEntity(Book.class)
                      .doOnNext(book -> {
                        System.err.println("-------");
                          System.out.println(book);
                        System.err.println("-------");
                      })
          .subscribe();

      Thread.sleep(5000);
    };
  }

}
