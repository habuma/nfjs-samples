package habuma.booksql;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping
    public Iterable<Author> allAuthors() {
        return authorRepo.findAll();
    }

    @PostMapping
    public Author save(@RequestBody Author author) {
        return authorRepo.save(author);
    }

}
