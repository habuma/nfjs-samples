package com.example.springbooksgraphql;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBooksGraphqlApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBooksGraphqlApplication.class, args);
  }

  @Bean
  ApplicationRunner init(BookRepository repo, AuthorRepository authorRepo) {
    return args -> {
      Author donald = authorRepo.save(new Author("Donald", "Knuth"));
      Author harold = authorRepo.save(new Author("Harold", "Abelson"));
      Author michael = authorRepo.save(new Author("Michael", "Sipser"));

      repo.save(new Book("1122334455", "The Art of Computer Programming", donald));
      repo.save(new Book("5544332211", "Structure and Interpretation of Computer Programs", harold));
      repo.save(new Book("1199228833", "Introduction to the Theory of Computation", michael));
    };
  }

}
