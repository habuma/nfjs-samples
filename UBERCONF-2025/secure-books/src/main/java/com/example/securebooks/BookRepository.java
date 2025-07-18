package com.example.securebooks;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

  Iterable<Book> findByReader(String reader);

}
