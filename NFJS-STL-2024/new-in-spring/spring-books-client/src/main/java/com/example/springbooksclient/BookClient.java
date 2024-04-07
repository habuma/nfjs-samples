package com.example.springbooksclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("http://localhost:8080/books")
public interface BookClient {

  @GetExchange("/{isbn}")
  Book getBook(@PathVariable("isbn") String isbn);

}
