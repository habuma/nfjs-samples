package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	private RestTemplate rest;

	public HelloController(RestTemplate rest) {
		this.rest = rest;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return rest.getForObject("http://hello-service/", String.class);
	}
	
}
