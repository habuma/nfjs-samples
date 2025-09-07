package com.example.springbooks;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

  private final JdbcClient jdbcClient;

  public BookRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  public List<Book> findAll() {
    return jdbcClient
        .sql("SELECT id, isbn, title, author FROM book")
        .query(Book.class)
        .list();
  }

  public Book save(Book book) {

    jdbcClient.sql("INSERT INTO book (id, isbn, title, author) VALUES (?, ?, ?, ?)")
        .param(book.id())
        .param(book.isbn())
        .param(book.title())
        .param(book.author())
        .update();

    return book;
  }

}
