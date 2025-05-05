package com.example.springbooksjdbc;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

@SpringBootApplication
public class SpringBooksJdbcApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBooksJdbcApplication.class, args);
  }

  @Bean
  ApplicationRunner doStuff(JdbcClient jdbcClient) {
    return args -> {
      KeyHolder keyHolder = new GeneratedKeyHolder();

      jdbcClient.sql("insert into Book (isbn, title, author) values ( :isbn, :title, :author )")
          .param("isbn", "9781603090575")
          .param("title", "How to Program")
          .param("author", "Deitel & Deitel")
          .update(keyHolder);

      List<Book> list = jdbcClient.sql("select id, isbn, title, author from Book")
          .query(Book.class)
          .list();

      list.stream()
          .forEach(System.out::println);
    };
  }

}
