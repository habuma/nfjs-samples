package habuma.booksql;

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
    public Author addAuthor(@Argument("firstName") String firstName,
                            @Argument("lastName") String lastName) {
        return authorRepo.save(new Author(firstName, lastName));
    }

    @MutationMapping("addAuthor2")
    public Author addAuthor2(@Argument("author") Author author) {
        return authorRepo.save(author);
    }

}
