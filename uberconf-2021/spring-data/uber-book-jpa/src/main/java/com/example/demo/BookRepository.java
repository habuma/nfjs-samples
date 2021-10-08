package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository 
	extends CrudRepository<Book, Long> {
	
	Iterable<Book> findByAuthor(String author);
	
	Iterable<SimpleBook> findSimpleByAuthor(String author);
	
	@Query("from Book b where b.author='Kendall Crolius'")
	Iterable<Book> findKendallsBooks();
}
