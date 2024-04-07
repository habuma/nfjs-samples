package habuma.reactivemongobooks;

import org.springframework.data.domain.Example;
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

    @GetMapping(path="/stream", produces="application/stream+json")
    public Flux<TitleAndAuthor> streamBooks() {
        return repo.findBy();
    }

    @GetMapping
    public Flux<Book> allBooks() {
        return repo.findAll();
    }

    @GetMapping("/{isbn}")
    public Mono<Book> byIsbn(String isbn) {
        return repo.findByIsbn(isbn);
    }

    @PostMapping
    public Mono<Book> save(@RequestBody Book book) {
        return repo.save(book);
    }

    @GetMapping("/kendallsBooks")
    public Flux<Book> kendallsBooks() {
        Book exampleBook = new Book(null, null, null, "Kendall Crolius");
        Example<Book> example = Example.of(exampleBook);
        return repo.findAll(example);
    }


}
