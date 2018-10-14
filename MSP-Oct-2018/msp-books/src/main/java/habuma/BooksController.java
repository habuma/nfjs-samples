package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
@RequiredArgsConstructor
public class BooksController {

	private final BookRepository repo;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		log.debug("Getting all books");
		return repo.findAll();
	}
	
}
