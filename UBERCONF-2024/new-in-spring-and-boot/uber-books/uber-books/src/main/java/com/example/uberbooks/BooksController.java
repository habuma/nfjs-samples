package com.example.uberbooks;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BookRepository bookRepository;
  private final JdbcClient jdbcClient;
  private final ObservationRegistry registry;

  public BooksController(BookRepository bookRepository, JdbcClient jdbcClient, ObservationRegistry registry) {
    this.bookRepository = bookRepository;
    this.jdbcClient = jdbcClient;
    this.registry = registry;
  }

  @GetMapping
  public Iterable<Book> getBooks() throws Exception {
    Observation obs = Observation.createNotStarted("getBooks", registry);
    obs.start();
    Iterable<Book> booksObserved = this.getBooksObserved();
    obs.stop();
    return booksObserved;
  }

  public Iterable<Book> getBooksObserved() throws Exception {
    Thread.sleep(2000);
    return jdbcClient
        .sql("select id, isbn, title, author from book")
        .query(Book.class)
        .list();
//    return bookRepository.findAll();
  }

  @GetMapping("/{isbn}")
  public Book getBookByIsbn(@PathVariable("isbn") String isbn) {
    return bookRepository.findByIsbn(isbn)
        .orElseThrow(() -> new BookNotFoundException(isbn));
  }

  @PostMapping
  public Book addBook(@RequestBody Book book) {
    return bookRepository.save(book);
  }

}
