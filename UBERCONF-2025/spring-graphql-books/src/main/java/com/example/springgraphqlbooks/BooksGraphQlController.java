package com.example.springgraphqlbooks;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksGraphQlController {

  private final BookRepository bookRepo;
  private final AuthorRepository authorRepo;
  private final BookRepository bookRepository;

  public BooksGraphQlController(BookRepository bookRepo, AuthorRepository authorRepo, BookRepository bookRepository) {
    this.bookRepo = bookRepo;
    this.authorRepo = authorRepo;
    this.bookRepository = bookRepository;
  }

  @MutationMapping("addBook")
  public Book addBook(@Argument("isbn") String isbn,
                      @Argument("title") String title,
                      @Argument("authorFirstName") String authorFirstName,
                      @Argument("authorLastName") String authorLastName) {
    var author = authorRepo.save(new Author(authorFirstName, authorLastName));
    var book = new Book(isbn, title, author);
    return bookRepo.save(book);
  }

  @MutationMapping("addBook2")
  public Book addBook2(@Argument("book") Book book) {
    var author = authorRepo.save(new Author(book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
    return bookRepository.save(new Book(book.getIsbn(), book.getTitle(), author));
  }

//  @QueryMapping("allBooks")
//  public Iterable<Book> getAllBooks() {
//    return bookRepo.findAll();
//  }
//
//  @QueryMapping("byIsbn")
//  public Book getBookByIsbn(@Argument("isbn") String isbn) {
//    return bookRepo.findByIsbn(isbn)
//                   .orElseThrow(() -> new BookNotFoundException(isbn));
//  }

}
