package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController { 

	@GetMapping("/hello")
	public Mono<String> hello() {
		Mono<String> stringMono = Mono.just("Hello reactive world!")
				.map(s -> {
					System.out.println("IN LAMBDA");
					return s.toUpperCase();
				});
		System.out.println("STILL IN CONTROLLER METHOD");
		return stringMono;
	}
	
}
