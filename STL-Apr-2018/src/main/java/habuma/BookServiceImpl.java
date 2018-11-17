package habuma;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl {
	private final BookRepository repo;
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}

}
