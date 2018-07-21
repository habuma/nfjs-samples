package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/greeting")
@Slf4j
public class GreetingController {

	@GetMapping
	public String giveGreeting() {
		log.info("Returning a greeting");
		return "Hello";
	}
	
}
