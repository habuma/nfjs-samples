package com.habuma.booksgraphql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BookRepository bookRepository;

  public BooksController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping
  public Iterable<Book> allBooks() {
    return bookRepository.findAll();
  }

  @GetMapping("/{isbn}")
  public Book bookByIsbn(@PathVariable("isbn") String isbn) {
    return bookRepository.findByIsbn(isbn);
  }

  @GetMapping("/author/{lastName}")
  public Iterable<Book> booksByAuthorLastName(@PathVariable("lastName") String lastName) {
    return bookRepository.findBooksByAuthorLastName(lastName);
  }

  @PostMapping
  public Book addBook(@RequestBody Book book) {
    return bookRepository.save(book);
  }

}
