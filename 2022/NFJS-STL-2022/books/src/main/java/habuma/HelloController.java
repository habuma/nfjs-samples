package habuma;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	@QueryMapping(name="hello")
	public String hello() {
		return "Hello graphql!";
	}
	
	@QueryMapping(name="helloTo")
	public String helloTo(@Argument("who") String who) {
		return "Hello, " + who + "!";
	}
	
}
