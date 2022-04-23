package com.example.demo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlakyController {

	@GetMapping("/flaky")
	public String hello() {
		double random = Math.random();
		if (random > 0.5) {
			return "Hello";
		}
		
		throw new CrapHappenedException("The number was too low: " + random);
	}

	
}
