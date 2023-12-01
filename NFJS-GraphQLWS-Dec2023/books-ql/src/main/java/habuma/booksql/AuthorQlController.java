package habuma.booksql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorQlController {

    private final AuthorRepository repo;

    public AuthorQlController(AuthorRepository repo) {
        this.repo = repo;
    }

    @MutationMapping("createAuthor")
    public Author saveAuthor(
            @Argument("firstName") String firstName,
            @Argument("lastName") String lastName) {
        return repo.save(new Author(firstName, lastName));
    }

    @MutationMapping("createAuthor2")
    public Author saveAuthor2(
            @Argument("author") Author author) {
        return repo.save(author);
    }

}
