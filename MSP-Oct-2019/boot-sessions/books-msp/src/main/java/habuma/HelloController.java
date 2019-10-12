package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloController {

	private final GreetingProps props;
	
	@GetMapping("/hello")
	public String hello() {
		log.debug("WARNING: SAYING HELLO");
		return props.getMessage();
	}
	
}
