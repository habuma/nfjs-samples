package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloClientController {

	private final HelloService helloService;
	
	@GetMapping("/")
	public String hello() {
		String greeting = helloService.getGreeting();

		String who = helloService.getWho();
		
		log.info("Returning full message");		
		return greeting + " " + who + "!";
	}
	
}
