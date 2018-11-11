package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/myapi/books")
@RequiredArgsConstructor
public class BookController {

	private final BookRepository repo;
	private final GreetingProps props;
	private final MeterRegistry meters;
	
	@GetMapping("/hi")
	public String hi() {
		meters.counter("com.nofluffjuststuff", "A", "B").increment();
		return props.getMessage();
	}
	
	@GetMapping
	public Iterable<Book> findAll() {
		return repo.findAll();
	}
	
	@PostMapping
	public Book save(@RequestBody Book book) {
		return repo.save(book);
	}
	
	@GetMapping("/{isbn}")
	public Book findByIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping("/{isbn}/simple")
	public SimpleBook findSimpleByIsbn(@PathVariable("isbn") String isbn) {
		return repo.findSimpleByIsbn(isbn);
	}
	
	@GetMapping("/kendalls")
	public Iterable<Book> kendallsBooks() {
		return repo.kendallsBooks();
	}
	
}
