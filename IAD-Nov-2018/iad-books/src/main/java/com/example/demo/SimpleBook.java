package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public interface SimpleBook {
	String getIsbn();
	String getTitle();
	
	@Value("#{target.authorFirstName + ' :: ' + target.authorLastName}")
	String getAuthor();
	
	@Value("#{T(System).currentTimeMillis()}")
	long getTimestamp();
}
