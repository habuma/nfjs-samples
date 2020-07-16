package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping(path="/hellorest")
	public String hello() {
		return "Hello world!";
	}
	
}
