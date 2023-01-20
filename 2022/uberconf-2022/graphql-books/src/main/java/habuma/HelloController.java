package habuma;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	@QueryMapping(name = "hello")
	public String hello() {
		return "Hello GraphQL!";
	}
	
}
