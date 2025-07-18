package com.example.springgraphqlbooks;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksRestController {

  private final BookRepository bookRepo;

  public BooksRestController(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

  @GetMapping
  public Iterable<Book> getBooks() {
    return bookRepo.findAll();
  }

  @GetMapping("/{isbn}")
  public Book getBookByIsbn(@PathVariable("isbn") String isbn) {
    return bookRepo.findByIsbn(isbn)
                   .orElseThrow(() -> new BookNotFoundException(isbn));
  }

  @PostMapping
  public Book createBook(@RequestBody Book book) {
    return bookRepo.save(book);
  }

}
