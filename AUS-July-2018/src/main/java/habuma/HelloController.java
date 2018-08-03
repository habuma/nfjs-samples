package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
@Slf4j
public class HelloController {

	private final GreetingProps props;

	@GetMapping
	public String hello() {
		
		log.debug("HELLO FROM THE HELLO CONTROLLER");
		
		return props.getMessage();
	}
	
}
