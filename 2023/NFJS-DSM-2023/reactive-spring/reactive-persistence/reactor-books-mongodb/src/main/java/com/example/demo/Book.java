package com.example.demo;

import org.springframework.data.annotation.Id;

public record Book(
		@Id String id,
		String isbn,
		String title,
		String author
	) {

}
