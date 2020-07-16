package habuma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloController {
	
	@Autowired
	GreetingProps props;
	
//	@Autowired
//	MeterRegistry registry;

	@GetMapping("/hello")
	public String hello() {
		log.debug("GREETING IS: " + props.getMessage());
		
//		registry.counter("uberbooks", "greeting", "hello").increment();
		
		return "greeting";
	}
	
}
