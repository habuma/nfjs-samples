package hello;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private GreetingProps props;
	private ApplicationContext context;

	public HelloController(GreetingProps props, ApplicationContext context) {
		this.props = props;
		this.context = context;
	}
	
	@GetMapping("/hello")
	public String hello() throws Exception {
		Thread.sleep(20000);
		return props.getMessage();
	}
	
	@GetMapping("/break")
	public String breakTHings() {
		AvailabilityChangeEvent.publish(context, LivenessState.BROKEN);
		return "BROKEN";
	}
	
}
