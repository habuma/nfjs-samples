package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	@QueryMapping(name = "hello")
	public String hello() {
		return "Hello world";
	}
	
	@QueryMapping(name = "helloTo")
	public String helloTo(@Argument String who) {
		return "Hello, " + who + "!";
	}
	
}
