package com.example.ubergraphbooks;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Optional;

@Controller
public class BooksGraphController {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepo;

  public BooksGraphController(BookRepository bookRepository, AuthorRepository authorRepo) {
    this.bookRepository = bookRepository;
    this.authorRepo = authorRepo;
  }

  @QueryMapping("allBooks")
  public Iterable<Book> allBooks() {
    System.err.println("allBooks");
    return bookRepository.findAll();
  }

  @MutationMapping("addBook")
  public Book addBook(@Argument("book") Book book) {
    Author author = authorRepo.save(book.getAuthor());
    book.setAuthor(author);
    return bookRepository.save(book);
  }

  @MutationMapping("deleteBook")
  public Book deleteBook(@Argument("isbn") String isbn) {
    Optional<Book> bookOptional = bookRepository.findByIsbn(isbn);
    if (bookOptional.isPresent()) {
      Book book = bookOptional.get();
      bookRepository.delete(book);
      return book;
    } else {
      return null;
    }
  }

//  @QueryMapping("booksThatAreCheckedOut")
//  public Iterable<Book> booksThatAreCheckedOut(Principal principal) {
//    return bookRepository.booksThatAreCheckedOut(principal.getName());
//  }

}
