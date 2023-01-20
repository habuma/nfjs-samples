package com.example.demo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
	
	Mono<Book> findByIsbn(String i);
	
	Mono<SimpleBook> findSimpleByIsbn(String i);

	Flux<Book> findByAuthorAndTitleLike(String a, String t);
	
	@Query("select id, isbn, title, author from Book where author='Kendall Crolius'")
	Flux<Book> kendallsBooks();

}
