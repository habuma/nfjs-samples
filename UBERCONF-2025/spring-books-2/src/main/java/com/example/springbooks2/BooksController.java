package com.example.springbooks2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BookRepository bookRepository;

  public BooksController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping
  public List<Book> getBooks() {
    return bookRepository.findAll();
  }

}
