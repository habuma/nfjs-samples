package com.habuma.springbooks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BooksExceptionHandler {

  @ExceptionHandler(BookNotFoundException.class)
  public ProblemDetail handleBookNotFoundException(BookNotFoundException e) {

    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
    problemDetail.setTitle("Book not found");
    problemDetail.setDetail(e.getMessage());

    return problemDetail;
  }

}
