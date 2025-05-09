package com.habuma.booksgraphql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Book {

  @Id
  @GeneratedValue
  private Long id;
  private String isbn;
  private String title;

  @ManyToOne
  @Cascade(CascadeType.ALL)
  private Author author;

  public Book() {}

  public Book(String isbn, String title, Author author) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
  }

  public Long getId() {
    return id;
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

  public void setId(Long id) {
    this.id = id;
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
