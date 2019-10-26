package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloController {

	private final GreetingProps props;
	
	@GetMapping("/hello")
	public String hello() {
		log.info("Saying hello");
		return props.getMessage();
	}
	
}
