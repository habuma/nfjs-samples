package com.example.demo;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(WebRequest request) {
		Iterator<String> headerNames = request.getHeaderNames();
		System.out.println("REQUEST HEADERS: ");
		while(headerNames.hasNext()) {
			String headerName = headerNames.next();
			System.out.println("     ---->   " + headerName + " = " + request.getHeader(headerName));
		}
		return "Hello world!";
	}
	
	@GetMapping("/goodbye")
	public String bye() {
		return "Bye bye!";
	}
	
}
