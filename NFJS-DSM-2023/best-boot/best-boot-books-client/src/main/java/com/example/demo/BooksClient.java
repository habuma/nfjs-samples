package com.example.demo;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import reactor.core.publisher.Flux;

@HttpExchange(url="http://localhost:8080/books")
public interface BooksClient {

	@GetExchange
	Flux<Book> getBooks();
	
}
