package com.example.demo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository 
	extends CrudRepository<Book, Long> {
	
	Iterable<Book> findByAuthor(String author);
	
	@Query("select id, isbn, title, author from Book where author='Kendall Crolius'")
	Iterable<Book> findKendallsBooks();
}
