package com.example.demo;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Book {

	@Id
	private Long id;
	
	private final String isbn;
	private final String title;
	private final String author;
	
}
