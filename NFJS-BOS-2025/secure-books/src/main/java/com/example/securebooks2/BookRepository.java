package com.example.securebooks2;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

  Book findByIsbn(String isbn);

  List<Book> findByReader(String reader);

}
