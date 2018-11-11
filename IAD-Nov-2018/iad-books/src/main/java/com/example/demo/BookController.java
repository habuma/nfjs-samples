package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
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
	
}
