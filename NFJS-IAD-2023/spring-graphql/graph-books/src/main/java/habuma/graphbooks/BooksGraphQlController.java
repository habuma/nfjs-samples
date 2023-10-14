package habuma.graphbooks;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksGraphQlController {

    private final BookRepository repo;

    public BooksGraphQlController(BookRepository repo) {
        this.repo = repo;
    }

//    @QueryMapping("allBooks")
//    public Iterable<Book> allBooks() {
//        return repo.findAll();
//    }

}
