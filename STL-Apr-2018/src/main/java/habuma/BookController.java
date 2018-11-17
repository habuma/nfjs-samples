package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/skoob")
@RequiredArgsConstructor
public class BookController {

	private final BookRepository repo;
	
	@GetMapping
	public Iterable<SimpleBook> books() {
		return repo.findSimpleBooksByFirstName("Kendall");
	}
	
}
