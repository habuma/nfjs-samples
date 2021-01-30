package com.example.demo;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class StreamingController {
	@GetMapping(path="/stream", produces = MediaType.APPLICATION_NDJSON_VALUE)
	public Flux<CountEntry> stream(@RequestParam(name="count", defaultValue = "10") Integer count) {
		
		return Flux.interval(Duration.ofSeconds(1))
				.map(l -> new CountEntry(l))
				.take(count);
		
	}
	
}
