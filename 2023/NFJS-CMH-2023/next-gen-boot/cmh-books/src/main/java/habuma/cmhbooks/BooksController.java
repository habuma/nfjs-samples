package habuma.cmhbooks;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{isbn}")
    public Book byIsbn(@PathVariable("isbn") String isbn2) {
        return repo.findByIsbn(isbn2);
    }

    @PostMapping
    public Book addBooks(@RequestBody Book book) {
        return repo.save(book);
    }

}
