package habuma.mspbooks;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookRepository repo;
    private final BooksService service;

    public BooksController(BookRepository repo, BooksService service) {
        this.repo = repo;
        this.service = service;
    }

    @GetMapping
    public Flux<Book> allBooks() {
        return repo.findAll();
    }



    @GetMapping("/{isbn}")
    public Mono<Book> byIsbn(@PathVariable("isbn") String isbn) {
        return service.findByIsbn(isbn);
    }

    @PostMapping
    public Mono<Book> saveBook(@RequestBody Book book) {
        return repo.save(book);
    }
}
