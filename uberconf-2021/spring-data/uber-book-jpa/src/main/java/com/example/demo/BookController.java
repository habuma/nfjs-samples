package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mvc/books")
public class BookController {

	private final BookRepository repo;
	
	public BookController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping(params="author")
	public Iterable<Book> byAuthor(@RequestParam("author") String author) {
		return repo.findByAuthor(author);
	}	
	
	@GetMapping(params={"author", "simple"})
	public Iterable<SimpleBook> bySimpleAuthor(@RequestParam("author") String author) {
		return repo.findSimpleByAuthor(author);
	}	
	
	@GetMapping("/kendalls")
	public Iterable<Book> kendalls() {
		return repo.findKendallsBooks();
	}
	
	
	@PostMapping
	public Book saveABook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
