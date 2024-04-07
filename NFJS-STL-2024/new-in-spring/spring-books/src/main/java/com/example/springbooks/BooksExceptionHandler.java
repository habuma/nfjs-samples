package com.example.springbooks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BooksExceptionHandler {

  @ExceptionHandler(BookNotFoundException.class)
  public ProblemDetail handleBookNotFoundException(BookNotFoundException e) {

    ProblemDetail problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Book not found");
    problemDetail.setProperty("isbn", e.getIsbn());

    return problemDetail;
  }

}
