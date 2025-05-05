package com.example.springbooksgraphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksGraphQlController {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  public BooksGraphQlController(BookRepository bookRepository,
                                AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

//  @QueryMapping("allBooks")
//  public Iterable<Book> allBooks() {
//    System.err.println("allBooks");
//    return bookRepository.findAll();
//  }

  @MutationMapping("addBook")
  public Book addBook(
      @Argument String isbn,
      @Argument String title,
      @Argument String authorFirstName,
      @Argument String authorLastName) {
    Author newAuthor = authorRepository.save(new Author(authorFirstName, authorLastName));
    return bookRepository.save(new Book(isbn, title, newAuthor));
  }

}
