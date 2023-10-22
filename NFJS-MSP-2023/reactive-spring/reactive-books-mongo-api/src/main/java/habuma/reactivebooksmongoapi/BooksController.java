package habuma.reactivebooksmongoapi;

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

        return repo.findBy()
                .map(book -> {
                    return new Book(book.id(), book.isbn(), book.title().toUpperCase(), book.author().toLowerCase());
                });
    }

    @GetMapping("/{isbn}")
    public Mono<Book> byIsbn(@PathVariable("isbn") String isbn) {

//        Book book = repo.findByIsbn(isbn).block();
//
//        Book alteredBook = new Book(book.id(), book.isbn(), book.title().toUpperCase(), book.author().toLowerCase());
//
//        // return
//        Mono.just(alteredBook);

        return repo.findByIsbn(isbn)
                .map(book -> {
                    return new Book(book.id(), book.isbn(), book.title().toUpperCase(), book.author().toLowerCase());
                });
    }

    @PostMapping
    public Mono<Book> saveBook(@RequestBody Book book) {
        repo.count().subscribe(System.out::println);

        Mono<Book> savedBookMono = repo.save(book);

        repo.count().subscribe(System.out::println);

        return savedBookMono;
    }

}
