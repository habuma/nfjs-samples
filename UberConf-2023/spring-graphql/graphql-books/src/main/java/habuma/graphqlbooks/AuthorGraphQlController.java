package habuma.graphqlbooks;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphQlController {

    private final AuthorRepository authorRepo;

    public AuthorGraphQlController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @MutationMapping("addAuthor")
    public Author save(@Argument("author") Author author) {
        return authorRepo.save(author);
    }
}
