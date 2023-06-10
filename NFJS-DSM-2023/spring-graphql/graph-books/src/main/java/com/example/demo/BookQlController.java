package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookQlController {

	private BookRepository repo;

	public BookQlController(BookRepository repo) {
		this.repo = repo;
	}
	
//	@QueryMapping("allBooks")
//	public Iterable<Book> allBooks() {
//		return repo.findAll();
//	}
	
	@MutationMapping("deleteByIsbn")
	public Book dbi(@Argument("isbn") String isbn) {
		Book book = repo.findByIsbn(isbn);
		repo.delete(book);
		return book;
	}
	
}
