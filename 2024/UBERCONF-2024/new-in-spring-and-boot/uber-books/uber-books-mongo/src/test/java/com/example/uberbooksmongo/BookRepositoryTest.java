package com.example.uberbooksmongo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class BookRepositoryTest extends MongoContainerConfig {

  @Autowired
  BookRepository repo;

  @Test
  public void test() {

    Book saved = repo.save(new Book(null, "123", "title", "author"));

    Book found = repo.findByIsbn("123").get();

    Assertions.assertThat(found.author()).isEqualTo("author");

  }

}
