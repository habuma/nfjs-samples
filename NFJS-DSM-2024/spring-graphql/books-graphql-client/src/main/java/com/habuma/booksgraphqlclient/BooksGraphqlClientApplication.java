package com.habuma.booksgraphqlclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class BooksGraphqlClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(BooksGraphqlClientApplication.class, args);
  }

  @Bean
  ApplicationRunner go(WebClient.Builder webClientBuilder) {
    return args -> {

      HttpGraphQlClient graphQl = HttpGraphQlClient.builder()
          .webClient(c -> {
            c.baseUrl("http://localhost:8080/graphql");
          })
          .build();

      // Query for all books
      Mono<List<Book>> booksMono = graphQl
          .document("{ allBooks { isbn title author { firstName lastName }}}")
          // alternatively...reference the same query in a file.
//          .documentName("allBooks")
          .retrieve("allBooks")
          .toEntityList(Book.class);

      booksMono
          .flatMapMany(bookList -> {
            return Flux.fromIterable(bookList);
          })
          .doOnNext(book -> {
            System.out.println("  -  " + book.getTitle());
          })
          .subscribe();

      // Sleeping for 1 second to give the flux (which is in a different thread)
      // a chance to do its thing before starting the next query.
      Thread.sleep(1000);

      System.err.println("----------");

      // Query for a book by ISBN
      Mono<Book> bookMono = graphQl.documentName("bookByIsbn")
          .variable("isbn", "1122334455")
          .retrieve("book")
          .toEntity(Book.class);

      bookMono
          .doOnNext(book -> {
            System.out.println("  -  " + book.getTitle() + " by " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
          })
          .subscribe();

      // Sleeping for 1 second to give the flux (which is in a different thread)
      // a chance to do its thing before the main thread ends.
      Thread.sleep(1000);

    };
  }

}
