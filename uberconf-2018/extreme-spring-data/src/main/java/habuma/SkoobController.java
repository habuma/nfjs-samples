package habuma;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/skoob")
@RequiredArgsConstructor
public class SkoobController {

	private final BookRepository repo;
	
	@GetMapping("/qbe")
	public Iterable<Book> qbe() {
		Book book = new Book(null, null, "CRAIG", "ROWLING");
		Example<Book> example = Example.of(book, 
				ExampleMatcher.matchingAny()
					.withIgnoreCase("authorFirstName", "authorLastName")
					);
		return repo.findAll(example);
	}
	
	@GetMapping("/simple")
	public Iterable<SimpleBook> simple() {
		return repo.findSimpleBy();
	}
}
