package com.example.graphbooks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BookRepository bookRepo;

  public BooksController(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

  @GetMapping
  public Iterable<Book> getBooks() {
    return bookRepo.findAll();
  }

  @GetMapping("/{isbn}")
  public Book getBook(@PathVariable String isbn) {
    return bookRepo.findByIsbn(isbn);
  }

  @PostMapping
  public Book addBook(@RequestBody Book book) {
    return bookRepo.save(book);
  }

}
