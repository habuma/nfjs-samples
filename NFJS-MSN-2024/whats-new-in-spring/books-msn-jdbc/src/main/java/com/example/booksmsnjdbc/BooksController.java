package com.example.booksmsnjdbc;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final JdbcClient jdbc;

  public BooksController(JdbcClient jdbc) {
    this.jdbc = jdbc;
  }

  @GetMapping
  public Iterable<Book> getBooks() {

    Iterable<Book> books = jdbc
        .sql("select id, isbn, title, author from Books")
//        .param(1, "1122334455x")
        .query(Book.class)
        .list();

    return books;
  }

}
