package habuma;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private ApplicationContext context;
	private GreetingProps props;

	public HelloController(ApplicationContext context, GreetingProps props) {
		this.context = context;
		this.props = props;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return props.getMessage();
	}
	
	@GetMapping("/ready")
	public String ready() {
		AvailabilityChangeEvent.publish(context, ReadinessState.ACCEPTING_TRAFFIC);
		return "ready";
	}
	
	@GetMapping("/notready")
	public String notReady() {
		AvailabilityChangeEvent.publish(context, ReadinessState.REFUSING_TRAFFIC);
		return "not ready";
	}
	
	@GetMapping("/alive")
	public String alive() {
		AvailabilityChangeEvent.publish(context, LivenessState.CORRECT);
		return "alive";
	}
	
	@GetMapping("/dead")
	public String dead() {
		AvailabilityChangeEvent.publish(context, LivenessState.CORRECT);
		return "dead";
	}
	
}
