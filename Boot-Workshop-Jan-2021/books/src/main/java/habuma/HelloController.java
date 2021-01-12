package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private GreetingProps props;

	public HelloController(GreetingProps props) {
		this.props = props;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return props.getMessage();
	}
	
}
