package habuma.graphbooks;

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
    public Author addAuthor(
            @Argument("author") Author author) {
        return authorRepo.save(author);
    }

}
