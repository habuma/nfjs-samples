package habuma;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphController {

	private AuthorRepository repo;

	AuthorGraphController(AuthorRepository repo) {
		this.repo = repo;
	}
	
	// what about lengthy subselects???
	// see README
	
	@MutationMapping("addAuthor")
	public Author addAuthor(@Argument String firstName, @Argument String lastName) {
		return repo.save(new Author(firstName, lastName));
	}

	@MutationMapping("addAuthor2")
	public Author addAuthor(@Argument Author author) {
		return repo.save(author);
	}

}
