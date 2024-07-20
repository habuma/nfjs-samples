package com.example.uberbooksmongo;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

public class MongoContainerConfig {

  @ServiceConnection
  @Container
  static MongoDBContainer mongo =
      new MongoDBContainer("mongo:latest");


}
