package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class WebClientTests {

	@Test
	public void testStuff() throws Exception {

		Mono<String> mono = WebClient.builder()
			.baseUrl("https://www.habuma.com")
			.build()
			
			.get()
			.exchangeToMono(response -> {
				return response.bodyToMono(String.class);
			});
		
		
		mono
			.doOnNext(h -> {
				System.out.println(h);
			})
			.subscribe();
	}
	
}
