package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Mono<String> hello() {
		return Mono.just("Hello world!")
				.map(s -> s.toUpperCase());
	}
	
}
