package com.example.graphbooks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface BookRepository
    extends CrudRepository<Book, Long>,
            QueryByExampleExecutor<Book> {

  Book findByIsbn(String isbn);

}
