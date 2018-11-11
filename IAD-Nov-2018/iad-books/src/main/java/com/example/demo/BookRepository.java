package com.example.demo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository 
	extends CrudRepository<Book, String> {
	
	Book findByIsbn(String isbn);
	
	SimpleBook findSimpleByIsbn(String isbn);
	
	Iterable<Book> findByAuthorFirstNameAndAuthorLastName(String fn, String ln);
		
	@Query("{'authorFirstName':'Kendall', 'authorLastName':'Crolius'}")
	Iterable<Book> kendallsBooks();
	
}
