package com.example.uberbooksclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("http://localhost:8080/books")
public interface BookClient {

  @GetExchange
  List<Book> getAllBooks();

  @GetExchange("/{isbn}")
  Book getBookByIsbn(@PathVariable("isbn") String isbn);

}
