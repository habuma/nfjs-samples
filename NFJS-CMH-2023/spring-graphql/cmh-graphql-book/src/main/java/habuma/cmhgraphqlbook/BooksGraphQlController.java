package habuma.cmhgraphqlbook;

import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksGraphQlController {
    private BookRepository bookRepo;

    BooksGraphQlController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

//    @QueryMapping("allBooks")
//    public Iterable<Book> allBooks() {
//        return bookRepo.findAll();
//    }

}
