package com.example.springbooksgraphql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BookRepository repo;

  public BooksController(BookRepository repo) {
    this.repo = repo;
  }

  @GetMapping
  public Iterable<Book> getBooks() {
    return repo.findAll();
  }

  @GetMapping("/{isbn}")
  public Book getBook(@PathVariable("isbn") String isbn) {
    return repo.findByIsbn(isbn);
  }

  @PostMapping
  public Book addBook(@RequestBody Book book) {
    return repo.save(book);
  }

}
