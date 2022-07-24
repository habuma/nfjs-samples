package com.example.demo;

public interface SimpleBook {

	String getIsbn();
	String getTitle();
	String getAuthor();
	
//	@Value("#{target.author.split(' ')[0]}")
//	String getAuthorFirstName();
//	
//	@Value("#{target.author.split(' ')[1]}")
//	String getAuthorLastName();
	
}
