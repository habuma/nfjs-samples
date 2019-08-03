package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HelloController {

	private final GreetingProps props;
	private final MeterRegistry registry;

	@GetMapping("/hello")
	public String hello(Model model) {
		
		registry.counter("dsm-books", "hello", props.getWho())
				.increment();
		
		model.addAttribute("who", props.getWho());
		return "hello-view";
	}
	
	@GetMapping("/hello/{who}")
	public String hello(@PathVariable("who") String who, Model model) {
		
		registry.counter("dsm-books", "hello", who)
				.increment();
		
		model.addAttribute("who", who);
		return "hello-view";
	}
}
