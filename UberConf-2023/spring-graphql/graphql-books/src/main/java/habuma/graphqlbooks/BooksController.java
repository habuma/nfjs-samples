package habuma.graphqlbooks;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookRepository bookRepo;

    public BooksController(BookRepository bookRepo, AuthorRepository authorRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public Iterable<Book> allBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/{isbn}")
    public Optional<Book> bookByIsbn(@PathVariable String isbn) {
        return bookRepo.findByIsbn(isbn);
    }

    @PostMapping
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

}
