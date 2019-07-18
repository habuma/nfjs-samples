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
	
	private final MessageProps props;
	private final MeterRegistry registry;
	
	@GetMapping("/hello")
	public String hello(Model model) {
		
		registry.counter("uberconf", "hello", "world").increment();
		
		log.debug("SAYING HELLO");
		model.addAttribute("who", props.getWho());
		return "hello-view";
	}
	
}
