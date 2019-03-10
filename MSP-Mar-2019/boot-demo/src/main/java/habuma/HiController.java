package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class HiController {

	private GreetingProps props;
	private MeterRegistry meterRegistry;

	public HiController(GreetingProps props, MeterRegistry meterRegistry) {
		this.props = props;
		this.meterRegistry = meterRegistry;
	}
	
	@GetMapping("/hi")
	public String hi() {
		meterRegistry.counter("demoApp", "hi", "counter")
		.increment();
		
		return props.getMessage();
	}
	
}
