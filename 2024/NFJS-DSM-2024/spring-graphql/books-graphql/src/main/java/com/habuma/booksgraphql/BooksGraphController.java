package com.habuma.booksgraphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksGraphController {

  private final BookRepository bookRepository;

  public BooksGraphController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
  
//  @QueryMapping("allBooks")
//  public Iterable<Book> allBooks() {
//    return bookRepository.findAll();
//  }

//  @MutationMapping("createBook")
//  public Book createBook(
//      @Argument("isbn") String isbn,
//      @Argument("title") String title,
//      @Argument("author") Author author) {
//    return bookRepository.save(new Book(isbn, title, author));
//  }

  @MutationMapping("createBook")
  public Book createBook(@Argument("book") Book book) {
    return bookRepository.save(book);
  }
  
}
