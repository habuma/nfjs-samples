package com.example.nfjsbooks;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJdbcTest
@Testcontainers
public class BookRepositoryTests {

  @Container
  @ServiceConnection
  private static final PostgreSQLContainer postgresContainer = new PostgreSQLContainer();

  @Test
  public void testStuff() {

  }

}
