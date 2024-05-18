package com.example.booksmsn;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BooksExceptionHandler {

  @ExceptionHandler(BookNotFoundException.class)
  public ProblemDetail handleBookNotFoundException(BookNotFoundException e) {

    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
    problemDetail.setDetail(e.getMessage());
    problemDetail.setProperty("MSN_Timestamp", System.currentTimeMillis());

    return problemDetail;
  }

}
