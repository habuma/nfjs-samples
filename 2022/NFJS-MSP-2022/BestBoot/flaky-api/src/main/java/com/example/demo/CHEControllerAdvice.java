package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CHEControllerAdvice {

	@ExceptionHandler(CrapHappenedException.class)
	@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
	public StandardError handler(CrapHappenedException e) {
		return new StandardError(
				123, 
				e.getMessage(), 
				"Pick a bigger number");
	}
	
}
