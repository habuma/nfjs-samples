package com.example.graphbooks;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

//@Controller
public class BooksGraphController {

  private final BookRepository bookRepo;

  public BooksGraphController(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

//  @QueryMapping("books")
  public Iterable<Book> allBooks(BookRepository bookRepo) {
    System.err.println("CALLING allBooks()");

    return bookRepo.findAll();
  }

}
