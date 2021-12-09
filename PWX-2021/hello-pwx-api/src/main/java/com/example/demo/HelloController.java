package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Greeting greeting() {
		Greeting greeting = new Greeting();
		greeting.setMessage("Hiya");
		greeting.setWho("Clearwater");
		return greeting;
	}
	
}
