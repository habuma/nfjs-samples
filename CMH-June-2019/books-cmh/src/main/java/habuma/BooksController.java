package habuma;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
@RequiredArgsConstructor
public class BooksController {

	private final BooksRepository repo;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		log.debug("GETTING ALL BOOKS");
		return repo.findAll();
	}
	
	
	
	@GetMapping("/{id}")
	public SimpleBook byId(@PathVariable("id") Long id) {
		return repo.findSimpleById(id);
	}
	
	
	
	
	@PostMapping
	public Book save(@RequestBody Book book) {
		return repo.save(book);
	}
}
