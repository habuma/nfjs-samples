package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BooksController {

	private BookRepository repo;

	public BooksController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Flux<Book> allBooks() {
		return repo.findAll();
	}
	
//	@GetMapping("/{id}")
//	public Mono<Book> byId(@PathVariable("id") long id) {
//		return repo.findById(id);
//	}
	
	@GetMapping("/dogs")
	public Flux<Book> dogBooks() {
		return repo.findByTitleLike("Dog");
	}
	
	@GetMapping("/{isbn}")
	public Mono<SimpleBook> byIsbn(@PathVariable("isbn") String isbn) {
		return repo.findSimpleByIsbn(isbn);
	}

	@GetMapping("/kendalls")
	public Flux<Book> kendalls() {
		return repo.kendallsBooks();
	}
	
	@PostMapping
	public Mono<Book> save(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
