package com.example.demo;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties.Problemdetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CrapHappenedRestControllerAdvice {

	@ExceptionHandler(CrapHappenedException.class)
	public ProblemDetail handle(CrapHappenedException e) {
		ProblemDetail detail = ProblemDetail
			.forStatusAndDetail(HttpStatus.I_AM_A_TEAPOT, e.getMessage());
		
		detail.setProperty("additionalInfo", "TOO_LOW");
		detail.setProperty("api_error_code", 112233L);
		return detail;
	}
	
}
