package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloController {

	private final GreetingProperties props;
	private final MeterRegistry registry;
	
	@GetMapping("/hello")
	public String hello() {
		
		registry.counter("boston-nfjs", "tag", "hello")
			.increment();
		
		
		log.debug("Hello is being called");
		return props.getMessage();
	}
	
}
