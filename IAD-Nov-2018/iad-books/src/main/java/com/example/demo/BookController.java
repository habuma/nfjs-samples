package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

	private final BookRepository repo;
	private final GreetingProps props;
	
	@GetMapping("/hi")
	public String hi() {
		return props.getMessage();
	}
	
	@GetMapping
	public Iterable<Book> findAll() {
		return repo.findAll();
	}
	
}
