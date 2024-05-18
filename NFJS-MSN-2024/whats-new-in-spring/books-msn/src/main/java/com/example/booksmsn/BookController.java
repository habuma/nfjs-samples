package com.example.booksmsn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

  private final BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping
  public Iterable<Book> getBooks() {
    return bookRepository.findAll();
  }

  @GetMapping("/{isbn}")
  public Book getBookByIsbn(@PathVariable String isbn) {
    Book byIsbn = bookRepository.findByIsbn(isbn);

    if (byIsbn == null) {
      throw new BookNotFoundException(isbn);
    }

    return byIsbn;
  }

  @PostMapping
  public Book addBook(@RequestBody Book book) {
    return bookRepository.save(book);
  }

}
