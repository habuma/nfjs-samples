package habuma.books;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {

	private final GreetingProps props;
	
	private final MeterRegistry reg;
	
	@GetMapping("/hello")
	public String hello() {
		reg.counter("demo.hello", "one", "two").increment();
		return props.getMessage();
	}
	
}
