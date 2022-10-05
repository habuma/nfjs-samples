package habuma;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {
	
	private AuthorRepo repo;

	public AuthorController(AuthorRepo repo) {
		this.repo = repo;
	}

	@MutationMapping("addAuthor")
	public Author save(@Argument("author") Author author) {
		return repo.save(author);
	}
	
}
