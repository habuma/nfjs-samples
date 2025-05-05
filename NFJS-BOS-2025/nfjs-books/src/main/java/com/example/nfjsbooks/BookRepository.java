package com.example.nfjsbooks;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

  Book findByIsbn(String isbn);

}
