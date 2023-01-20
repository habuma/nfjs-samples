package habuma;

import org.springframework.data.domain.Example;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	private BookRepository repo;

	public HelloController(BookRepository repo) {
		this.repo = repo;
	}
	
	@QueryMapping("hello")
	public String hello() {
		return "Hello world!";
	}
	
	@QueryMapping("books")
	public Iterable<Book> books() {
		System.out.println("********** IN QUERY MAPPING FOR 'books'");
		return repo.findAll();
	}
	
}
