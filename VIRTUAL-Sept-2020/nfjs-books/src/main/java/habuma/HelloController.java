package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.micrometer.core.instrument.MeterRegistry;

@Controller
public class HelloController {

	private GreetingProps props;
	private MeterRegistry registry;

	public HelloController(GreetingProps props, MeterRegistry registry) {
		this.props = props;
		this.registry = registry;
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		
		registry.counter("nfjs-books", "hello", "count").increment();
		
		
		System.out.println("HI");
		model.addAttribute("message", props.getMessage());
		return "hello-view";
	}
	
}
