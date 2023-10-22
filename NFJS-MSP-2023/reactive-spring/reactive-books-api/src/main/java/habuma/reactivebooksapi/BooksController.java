package habuma.reactivebooksapi;

import org.springframework.data.domain.Example;
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
    public Mono<SimpleBookRecord> byIsbn(@PathVariable("isbn") String isbn) {
        return repo.findSimpleByIsbn(isbn);
    }

    @PostMapping
    public Mono<Book> saveBook(@RequestBody Book book) {
        repo.count().subscribe(System.out::println);

        Mono<Book> savedBookMono = repo.save(book);

        repo.count().subscribe(System.out::println);

        return savedBookMono;
    }

    @GetMapping("/kendalls")
    public Flux<Book> kendallsBooks() {
        Book book = new Book(null, null, null, "Kendall Crolius");
        Example example = Example.of(book);
        return repo.findAll(example);
    }

}
