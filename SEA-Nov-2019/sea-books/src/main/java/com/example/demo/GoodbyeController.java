package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodbyeController {

	@GetMapping("/goodbye")
	public String goodbye() {
		return "bye";
	}
	
}

