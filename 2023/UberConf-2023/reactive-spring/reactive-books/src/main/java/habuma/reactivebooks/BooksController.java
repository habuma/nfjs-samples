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

    @GetMapping("/{id}")
    public Mono<Book> byId(@PathVariable Long id) {
        System.out.println("!!!!! FINDING BY ID " + id);
        return repo.findById(id);
    }

    @PostMapping
    public Mono<Book> saveBook(@RequestBody Book book) {
        return repo.save(book);
    }

}
