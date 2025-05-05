package com.example.springbooksmongodb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
public class BookRepoTests {

  @Container
  @ServiceConnection
  static final MongoDBContainer container =
      new MongoDBContainer("mongo:5.0");

  @Autowired
  BookRepository bookRepository;

  @Test
  public void test() {

//    System.err.println("Container: " + container.getReplicaSetUrl());

    assertThat(bookRepository.count()).isEqualTo(3);
  }

}
