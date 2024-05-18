package com.example.booksmsn;

public class BookNotFoundException extends RuntimeException {
  public BookNotFoundException(String isbn) {
    super("Book not found with isbn: " + isbn);
  }
}
