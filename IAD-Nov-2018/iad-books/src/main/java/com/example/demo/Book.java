package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Document
@NoArgsConstructor(force=true, access=AccessLevel.PRIVATE)
@AllArgsConstructor
public class Book {

	@Id
	private String id;
	
	private String isbn;
	private String title;
	private String authorFirstName;
	private String authorLastName;
	
}
