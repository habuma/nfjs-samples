package com.example.booksmsn;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {

  Book findByIsbn(String isbn);

}
