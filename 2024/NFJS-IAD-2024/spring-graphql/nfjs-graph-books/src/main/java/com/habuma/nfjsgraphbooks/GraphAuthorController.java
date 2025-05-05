package com.habuma.nfjsgraphbooks;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphAuthorController {

  private final AuthorRepository authorRepo;

  public GraphAuthorController(AuthorRepository authorRepo) {
    this.authorRepo = authorRepo;
  }

  @MutationMapping("addAuthor")
  public Author saveAuthor(
        @Argument("author") Author author) {
    return authorRepo.save(author);
  }

}
