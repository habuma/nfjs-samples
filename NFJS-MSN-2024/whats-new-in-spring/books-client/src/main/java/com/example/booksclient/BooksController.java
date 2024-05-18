package com.example.booksclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BookClient bookClient;

  public BooksController(BookClient bookClient) {
    this.bookClient = bookClient;
  }

//  @GetMapping("/{isbn}")
  public Book getBookByIsbn(@PathVariable String isbn) {
    RestClient restClient = RestClient.create("http://localhost:8080");
    Book book = restClient.get()
        .uri("/books/{isbn}", isbn)
        .header("Authorization", "Bearer SOME_TOKEN") // doesn't mean anything, just for example's sake
        .retrieve()
        .body(Book.class);

    return book;
  }

  @GetMapping("/{isbn}")
  public Book getBookByIsbn2(@PathVariable String isbn) {
    return bookClient.getBookByIsbn(isbn);
  }

}
