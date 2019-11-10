package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

	private final GreetingProps props;
	
	@GetMapping("/hello")
	public String hello() {
		return props.getMessage();
	}
	
}
