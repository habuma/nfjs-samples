package com.example.demo;

import java.util.function.Function;

public class Lowercase implements Function<String, String> {

	@Override
	public String apply(String t) {
		return t.toLowerCase();
	}
	
}
