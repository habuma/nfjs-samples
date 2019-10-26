package com.example.demo;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mvc/books")
@RequiredArgsConstructor
public class BooksController {

	private final BooksRepository repo;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Book> byId(@PathVariable("id") Long id) {
		return repo.findById(id);
	}
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return repo.save(book);
	}
	
	@GetMapping("/kendalls")
	public Iterable<Book> kendallsBooks() {
		return repo.findByAuthorFirstName("Kendall");
	}	
	
	@GetMapping("/kendalls/simple")
	public Iterable<SimplePublication> kendallsSimpleBooks() {
		return repo.findSimpleByAuthorFirstName("Kendall");
	}	
}
