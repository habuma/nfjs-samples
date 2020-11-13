package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HelloController {
	
	private final GreetingProps props;
	
	private final MeterRegistry meter;

	@GetMapping("/hello")
	public String hello(Model model) {
		
		meter.counter("nfjs", "requests", "hello").increment();
		
		
		log.debug("HELLO CONTROLLER INVOKED");
		
		model.addAttribute("who", "You fools");
		model.addAttribute("message", props.getMessage());
		return "hello-view";
	}
	
}
