package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public interface SimpleBook {

	String getIsbn();
	String getTitle();
	
	@Value("#{target.author.split(' ')[0]}")
	String getFirstName();
	
	@Value("#{target.author.split(' ')[1]}")
	String getLastName();

	@Value("#{T(System).currentTimeMillis()}")
	Long getTimestamp();
	
}
