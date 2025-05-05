package com.example.springbooksmongodb;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
  Book findByIsbn(String isbn);
}
