package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix="greeting")
public class GreetingProps {

	private String message = "Hello";
	private String other;
	private String foo;
	
}
