package com.example.demo;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(WebRequest req) {
		logHeaders(req);
		return "Hello world!";
	}

	@GetMapping("/bye")
	public String bye(WebRequest req) {
		logHeaders(req);
		return "Bye!";
	}

	private void logHeaders(WebRequest req) {
		Iterator<String> headerNames = req.getHeaderNames();
		while(headerNames.hasNext()) {
			String headerName = headerNames.next();
			String value = req.getHeader(headerName);
			System.out.println("    -  " + headerName + " = " + value);
		}
	}
	
}
