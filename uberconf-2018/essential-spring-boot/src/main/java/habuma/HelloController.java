package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {

	private final GreetingProps props;
	
	@GetMapping("/hello")
	public String hello() {
		return props.getMessage();
	}
	
}
