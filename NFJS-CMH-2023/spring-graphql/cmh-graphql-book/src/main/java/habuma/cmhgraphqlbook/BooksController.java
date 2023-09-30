package habuma.cmhgraphqlbook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookRepository repo;

    BooksController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Book> allBooks() {
        return repo.findAll();
    }

    @GetMapping("/{isbn}")
    public Book byIsbn(@PathVariable("isbn") String isbn) {
        return repo.findByIsbn(isbn);
    }

}
