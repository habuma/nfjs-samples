package habuma.booksapi;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookRepository repo;

    public BooksController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Book> allBooks() {
        return repo.findAll();
    }

    @GetMapping("/isbn/{isbn}")
    public Book byIsbn(@PathVariable("isbn") String isbn) {
        Book book = repo.findByIsbn(isbn);
        if (book == null) {
            throw new UnknownBookException(isbn);
        }
        return book;
    }

    @GetMapping("/{id}")
    public Optional<Book> byId(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return repo.save(book);
    }

}
