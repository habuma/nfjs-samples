package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloGraphQlController {

	@QueryMapping("hello")
	public String hello() {
		return "Hello, world!";
	}
	
	@QueryMapping("helloTo")
	public String helloTo(@Argument("who") String who) {
		return "Hello, " + who + "!";
	}
	
}
