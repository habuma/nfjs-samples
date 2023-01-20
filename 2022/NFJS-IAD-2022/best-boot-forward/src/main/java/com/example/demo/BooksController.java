package com.example.demo;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

	private BookRepository repo;

	public BooksController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
//	@GetMapping("/{id}")
//	public Optional<Book> byId(@PathVariable("id") Book book) {
//		return Optional.of(book);
//	}
	
	@GetMapping("/{isbn}")
	public Optional<Book> byIsbn(@PathVariable("isbn") String isbn) {
		return Optional.of(repo.findByIsbn(isbn));
	}
	
	@GetMapping(path="/{isbn}", params = "simple")
	public Optional<SimpleBook> bySimpleIsbn(@PathVariable("isbn") String isbn) {
		return Optional.of(repo.findSimpleByIsbn(isbn));
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Book save(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
