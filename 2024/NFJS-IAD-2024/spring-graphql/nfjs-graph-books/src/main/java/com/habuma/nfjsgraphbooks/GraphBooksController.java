package com.habuma.nfjsgraphbooks;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphBooksController {

  private final BookRepository bookRepo;

  public GraphBooksController(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

  @MutationMapping("addBook")
  public Book saveBook(@Argument("book") Book book) {
    System.err.println("Saving book: " + book);
    return bookRepo.save(book);
  }

//  @QueryMapping("allBooks")
//  public Iterable<Book> allBooks() {
//    return bookRepo.findAll();
//  }

}
