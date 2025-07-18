package com.example.springbooks2;

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
    return jdbcClient.sql("select id, isbn, title, author from Book")
        .query(Book.class)
        .list();

  }

}
