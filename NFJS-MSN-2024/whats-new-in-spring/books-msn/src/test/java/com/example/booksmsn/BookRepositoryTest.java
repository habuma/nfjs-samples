package com.example.booksmsn;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public class BookRepositoryTest {

  @Container
  @ServiceConnection
  private static final MongoDBContainer mongoDBContainer =
      new MongoDBContainer("mongo:5.0");

  @Autowired
  BookRepository bookRepository;

  @Test
  void testRepository() throws  Exception {
    Iterable<Book> all = bookRepository.findAll();
    Assertions.assertThat(all).isEmpty();
    Thread.sleep(10000);
  }

}
