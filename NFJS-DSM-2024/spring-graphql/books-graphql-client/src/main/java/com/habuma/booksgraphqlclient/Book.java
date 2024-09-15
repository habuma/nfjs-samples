package com.habuma.booksgraphqlclient;

public class Book {

  private String isbn;
  private String title;

  private Author author;

  public Book() {}

  public Book(String isbn, String title, Author author) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getTitle() {
    return title;
  }

  public Author getAuthor() {
    return author;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

}
