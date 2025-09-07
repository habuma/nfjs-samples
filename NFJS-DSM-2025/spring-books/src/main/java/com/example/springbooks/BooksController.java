package com.example.springbooks;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BookRepository bookRepository;

  public BooksController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping
  public Iterable<Book> getBooks() {
    return bookRepository.findAll();
  }

  @PostMapping
  public Book addBook(@RequestBody Book book) {
    return bookRepository.save(book);
  }


}
