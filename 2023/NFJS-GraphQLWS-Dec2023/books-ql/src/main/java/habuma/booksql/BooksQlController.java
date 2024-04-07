package habuma.booksql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

//@Controller
public class BooksQlController {

    private final BookRepository repo;

    public BooksQlController(BookRepository repo) {
        this.repo = repo;
    }

//    @QueryMapping("allBooks")
//    public Iterable<Book> allBooks() {
//        return repo.findAll();
//    }
//
//    @QueryMapping("byIsbn")
//    public Book byIsbn(@Argument("isbn") String isbn) {
//        return repo.findByIsbn(isbn);
//    }

}
