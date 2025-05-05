package com.example.uberbooks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingAdvice {

  @ExceptionHandler(BookNotFoundException.class)
  public ProblemDetail handleBookNotFoundException(BookNotFoundException e) {

    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
    problemDetail.setProperty("isbn", e.getIsbn());
    return problemDetail;

  }

}
