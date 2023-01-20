package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerControllerAdvice {

	@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
	@ExceptionHandler(CrapHappenedException.class)
	public StandardizedError handleCrapHappened(CrapHappenedException e) {
		return new StandardizedError(1234L, e.getMessage());
	}
	
}
