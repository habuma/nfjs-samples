package habuma;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final GreetingProps props;
	private ApplicationContext context;
	
	public HelloController(GreetingProps props, ApplicationContext context) {
		this.props = props;
		this.context = context;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return props.getMessage();
	}
	
	@GetMapping("/goodbye")
	public String bye() {
		AvailabilityChangeEvent.publish(context, LivenessState.BROKEN);
		return "Bye bye";
	}
	
}
