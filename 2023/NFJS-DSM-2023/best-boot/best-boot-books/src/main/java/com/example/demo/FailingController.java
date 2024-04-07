package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FailingController {

	@GetMapping("/flaky")
	public String flaky() {
		double random = Math.random();
		if (random > 0.5) {
			return "Good!";
		}
		
		throw new CrapHappenedException("The value was too low: " + random);
	}
	
}
