package com.example.demo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface BookRepository 
	extends ReactiveCrudRepository<Book, String> {
	
	Flux<Book> findByAuthor(String author);
	
	@Query("{author:'Kendall Crolius'}")
	Flux<Book> findKendallsBooks();
}
