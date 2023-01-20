package habuma;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLHelloController {

	@QueryMapping("hello")
	public Greeting hello() {
		return new Greeting("Hello GraphQL!");
	}
	
}
