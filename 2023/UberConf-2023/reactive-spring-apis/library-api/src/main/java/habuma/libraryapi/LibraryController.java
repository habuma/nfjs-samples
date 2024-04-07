package habuma.libraryapi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    @RequestMapping("/isbn/{isbn}")
    public Mono<Book> getBookByIsbn(@PathVariable String isbn) {
        return service.getBookByIsbn(isbn);
    }
    
}
