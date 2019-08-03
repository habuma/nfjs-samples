package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HelloController {

	private final GreetingProps props;
	
	private final MeterRegistry registry;
	
	
	@GetMapping("/hello")
	public String hello(Model model) {
		
		registry.counter("austin", "abc", "def").increment();
		
		model.addAttribute("greeting", props.getMessage());
		return "hello-view";
	}
	
}
