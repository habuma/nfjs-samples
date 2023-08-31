package habuma.booksql;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookRepository bookRepo;

    public BooksController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public Iterable<Book> allBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/{isbn}")
    public Book byIsbn(@PathVariable("isbn") String isbn) {
        return bookRepo.findByIsbn(isbn);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

}
