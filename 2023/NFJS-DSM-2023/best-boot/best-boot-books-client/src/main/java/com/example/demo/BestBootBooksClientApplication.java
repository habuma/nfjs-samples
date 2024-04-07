package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class BestBootBooksClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestBootBooksClientApplication.class, args);
	}
	
	@Bean
	HttpServiceProxyFactory httpServiceProxyFactory() {
	  WebClient webClient = WebClient.create();
	  WebClientAdapter webClientAdapter = WebClientAdapter.forClient(webClient);
	  return HttpServiceProxyFactory.builder(webClientAdapter).build();
	}
	
	@Bean
	BooksClient bookApi(HttpServiceProxyFactory factory) throws Exception {
	   return factory.createClient(BooksClient.class);
	}
	
	@Bean
	ApplicationRunner go(BooksClient client) {
		return args -> {
			// using WebClient
			WebClient.create("http://localhost:8080")
				.get()
				.uri("/books")
				.retrieve()
				.bodyToFlux(Book.class)
				.subscribe(b -> {
					System.out.println("Book : " + b.title());
				});
			
			// using declarative client
			client.getBooks()
				.subscribe(book -> {
					System.out.println("BOOK : " + book.title());
				});
		};
	}

}
