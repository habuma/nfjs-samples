package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public interface SimpleBook {

	String getIsbn();
	String getTitle();
	
	@Value("#{target.author + '....' + target.isbn}")
	String getAuthorFullName();
	
}
