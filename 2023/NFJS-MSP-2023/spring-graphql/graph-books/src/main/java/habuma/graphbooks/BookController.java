package habuma.graphbooks;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepo;

    public BookController(BookRepository bookRepo) {
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
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

}
