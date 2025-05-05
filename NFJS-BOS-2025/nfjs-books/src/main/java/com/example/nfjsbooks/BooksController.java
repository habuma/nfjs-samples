package com.example.nfjsbooks;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BookRepository bookRepository;

  public BooksController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping
  public Iterable<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @GetMapping("/{isbn}")
  public Book getBookByIsbn(@PathVariable("isbn") String isbn) {
    return bookRepository.findByIsbn(isbn);
  }

  @PostMapping
  public Book addBook(@RequestBody Book book) {
    return bookRepository.save(book);
  }

}
