package com.example.securebooks;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BookRepository bookRepository;

  public BooksController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public Iterable<Book> getBooks(@AuthenticationPrincipal User user) {
    return bookRepository.findByReader(user.getUsername());
  }

  @PostMapping
  public Book createBook(@RequestBody Book book, @AuthenticationPrincipal User user) {
    return bookRepository.save(new Book(null, book.isbn(), book.title(), book.author(), user.getUsername()));
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Long id, @AuthenticationPrincipal User user) {
    Optional<Book> byId = bookRepository.findById(id);
    if (byId.isPresent()) {
      Book book = byId.get();
      if (!book.reader().equals(user.getUsername())) {
        throw new AuthorizationDeniedException("You can only delete books you own!") ;
      }
    } else {
      throw new IllegalArgumentException("Book not found with id: " + id);
    }
    bookRepository.deleteById(id);
  }

}
