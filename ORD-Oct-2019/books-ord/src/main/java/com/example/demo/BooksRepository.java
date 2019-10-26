package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, Long> {

	Iterable<Book> findByAuthorFirstName(String author);
	
	Iterable<SimplePublication> findSimpleByAuthorFirstName(String author);

	Book findByIsbn(String isbn);
	
}
