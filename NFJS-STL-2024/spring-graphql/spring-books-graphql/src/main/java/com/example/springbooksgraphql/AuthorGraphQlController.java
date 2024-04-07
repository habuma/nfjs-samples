package com.example.springbooksgraphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphQlController {

  private final AuthorRepository authorRepository;

  public AuthorGraphQlController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @MutationMapping("addAuthor")
  public Author addAuthor(
      @Argument String firstName,
      @Argument String lastName) {

    return authorRepository.save(new Author(firstName, lastName));
  }

//  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @MutationMapping("addAuthor2")
  public Author addAuthor2(@Argument Author author) {

    return authorRepository.save(author);
  }


}
