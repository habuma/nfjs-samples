package com.example.uberbooks;

public class BookNotFoundException extends RuntimeException {
  private final String isbn;

  public BookNotFoundException(String isbn) {
    super("Book not found with ISBN: " + isbn);
    this.isbn = isbn;
  }

  public String getIsbn() {
    return isbn;
  }

}
