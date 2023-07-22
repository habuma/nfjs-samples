package habuma.reactivebooks;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookRepository repo;

    public BooksController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Flux<Book> allBooks() {
        return repo.findAll();
    }

    @GetMapping("/{isbn}")
    public Mono<Book> byIsbn(@PathVariable String isbn) {
        return repo.findByIsbn(isbn);
    }

    @GetMapping("/simple/{isbn}")
    public Mono<SimpleBook> bySimpleIsbn(@PathVariable String isbn) {
        return repo.findSimpleByIsbn(isbn);
    }

    @PostMapping
    public Mono<Book> saveBook(@RequestBody Book book) {
        return repo.save(book);
    }

}
