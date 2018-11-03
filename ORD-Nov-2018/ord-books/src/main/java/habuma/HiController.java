package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HiController {

	private final GreetingProps props;
	private final MeterRegistry metrics;
	
	@GetMapping("/")
	public String hi() {		
		metrics.counter("greeting.message", "hello", "count").increment();
		
		return props.getMessage();
	}
	
}
