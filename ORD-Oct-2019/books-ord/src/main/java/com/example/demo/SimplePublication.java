package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "simple", types = Book.class)
public interface SimplePublication {

	String getTitle();
	
	@Value("#{target.authorFirstName + ' ' + target.authorLastName}")
	String getAuthor();
	
	@Value("#{T(System).currentTimeMillis()}")
	long getTimestamp();
	
}
