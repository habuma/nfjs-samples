package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class HelloController {
	
	private MeterRegistry mr;


	public HelloController(MeterRegistry mr) {
		this.mr = mr;
	}
	

	@GetMapping("/hello")
	public String hello() {
		
		mr.counter("hello.world", "hello", "count")
			.increment();
		
		return "Hello Redmond!!!!!!!!";
	}
	
}
