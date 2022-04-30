package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/goodbye")
	public String bye() {
		return "Bye!";
	}
	
}
