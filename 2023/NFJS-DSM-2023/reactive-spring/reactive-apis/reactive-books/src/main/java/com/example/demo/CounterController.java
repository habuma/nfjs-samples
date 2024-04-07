package com.example.demo;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class CounterController {

	@GetMapping(path="/counter", produces = "application/stream+json")
	public Flux<CounterTick> counter() {
		return Flux.interval(Duration.ofSeconds(2))
				.map(l -> new CounterTick(l))
				;
	}
	
}
