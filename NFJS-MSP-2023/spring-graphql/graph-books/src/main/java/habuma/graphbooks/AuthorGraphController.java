package habuma.graphbooks;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphController {

    private final AuthorRepository authorRepo;

    public AuthorGraphController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @MutationMapping("addAuthor")
    public Author addAuthor(
            @Argument("firstName") String firstName,
            @Argument("lastName") String lastName) {
        return authorRepo.save(new Author(firstName, lastName));
    }


}
