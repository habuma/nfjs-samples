package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() throws Exception {
		Thread.sleep(10000);
		return "Hello UberConf!";
	}
	
}
