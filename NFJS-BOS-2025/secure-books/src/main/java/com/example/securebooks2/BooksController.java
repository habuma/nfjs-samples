package com.example.securebooks2;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/reader")
//  public Book getBookByReader(@AuthenticationPrincipal UserDetails user) {
  public List<Book> getBookByReader() {
    var user = SecurityContextHolder.getContext().getAuthentication().getName();
    System.err.println(user);
    return bookRepository.findByReader(user);
  }

  @GetMapping("/{isbn}")
  public Book getBookByIsbn(@PathVariable("isbn") String isbn) {
    return bookRepository.findByIsbn(isbn);
  }

  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  public Book createBook(@RequestBody Book book) {
    return bookRepository.save(book);
  }

}
