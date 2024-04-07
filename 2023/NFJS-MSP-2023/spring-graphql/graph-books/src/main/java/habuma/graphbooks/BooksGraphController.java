package habuma.graphbooks;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksGraphController {

    private final BookRepository repo;

    public BooksGraphController(BookRepository repo) {
        this.repo = repo;
    }

    @MutationMapping("deleteBookByIsbn")
    public Book deleteBookByIsbn(@Argument("isbn") String isbn) {
        Book book = repo.findByIsbn(isbn);
        if (book != null) {
            repo.delete(book);
            return book;
        }
        return null;
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
