package com.habuma.nfjsgraphbooks;

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
  private final AuthorRepository authorRepository;

  public BooksController(BookRepository bookRepository, AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  @GetMapping
  public Iterable<Book> allBooks() {
    return bookRepository.findAll();
  }

//  @GetMapping("/{isbn}")
//  public Book bookByIsbn(@PathVariable String isbn) {
//    return bookRepository.findByIsbn(isbn);
//  }

  @PostMapping
  public Book saveBook(@RequestBody BookIn book) {
    Author author = new Author(book.authorFirstName(), book.authorLastName());
    Author savedAuthor = authorRepository.save(author);
    Book newBook = new Book(book.isbn(), book.title(), savedAuthor);
    return bookRepository.save(newBook);
  }

}
