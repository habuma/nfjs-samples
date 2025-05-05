package com.example.uberbooksmongo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, String> {

  Optional<Book> findByIsbn(String isbn);

}
