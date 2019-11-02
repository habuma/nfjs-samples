package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/mvc/books")
@RequiredArgsConstructor
@Slf4j
public class BooksController {

	private final BooksRepository repo;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		log.info("GETTING ALL BOOKS");
		return repo.findAll();
	}
	
	@GetMapping("/{isbn}")
	public Book bookByIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping("/{isbn}/simple")
	public SimplePublication simpleByIsbn(@PathVariable("isbn") String isbn) {
		return repo.findSimpleByIsbn(isbn);
	}
	
	@PostMapping
	public Book saveABook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
