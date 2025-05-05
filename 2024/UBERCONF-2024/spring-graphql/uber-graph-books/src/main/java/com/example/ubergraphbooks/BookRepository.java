package com.example.ubergraphbooks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.Optional;

@GraphQlRepository
public interface BookRepository
    extends CrudRepository<Book, Long>,
    QueryByExampleExecutor<Book> {

  Optional<Book> findByIsbn(String isbn);

//  @Query("...")
//  Iterable<Book> booksThatAreCheckedOut(String user);

}
