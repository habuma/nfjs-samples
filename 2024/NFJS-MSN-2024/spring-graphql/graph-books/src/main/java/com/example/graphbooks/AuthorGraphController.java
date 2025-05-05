package com.example.graphbooks;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphController {

  private final AuthorRepository repo;

  public AuthorGraphController(AuthorRepository repo) {
    this.repo = repo;
  }

  @MutationMapping("createAuthor")
  public Author createAuthor(
      @Argument("firstName") String firstName,
      @Argument("lastName") String lastName) {
    return repo.save(new Author(firstName, lastName));
  }

  @MutationMapping("createAuthor2")
  public Author createAuthor2(
      @Argument("author") Author author) {
    return repo.save(author);
  }

}
