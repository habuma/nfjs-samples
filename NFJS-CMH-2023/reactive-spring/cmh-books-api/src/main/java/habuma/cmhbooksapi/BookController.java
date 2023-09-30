package habuma.cmhbooksapi;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Flux<Book> allBooks() {
        return repo.findAll();
    }

    @GetMapping("/{isbn}")
    public Mono<Book> byIsbn(@PathVariable("isbn") String isbn) {
        return repo.findByIsbn(isbn);
    }

    @PostMapping
    public Mono<Book> addBook(@RequestBody Book book) {
        return repo.save(book);
    }

}
