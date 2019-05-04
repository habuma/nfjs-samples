package habuma.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {

	private final GreetingProps props;
	private final MeterRegistry registry;
	
	@GetMapping("/hello")
	public String hello() {
		
		registry.counter("habuma.books", "controller", "hello").increment();
		
		
		return props.getMessage();
	}
	
}
