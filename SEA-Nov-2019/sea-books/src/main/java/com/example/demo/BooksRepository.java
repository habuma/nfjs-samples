package com.example.demo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository 
	extends CrudRepository<Book, Long> {

	@Query("select id, isbn, title, author from Book where isbn=:isbn")
	Book findByIsbn(String isbn);
	
}
