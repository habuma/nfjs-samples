package com.example.springbooks;

public class BookNotFoundException extends RuntimeException {
  private final String isbn;

  public BookNotFoundException(String isbn) {
    this.isbn = isbn;
  }

  public String getIsbn() {
    return isbn;
  }
}
