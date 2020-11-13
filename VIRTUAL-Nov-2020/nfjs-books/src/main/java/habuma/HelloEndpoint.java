package habuma;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "hello", enableByDefault = true)
public class HelloEndpoint {
	
	@ReadOperation
	public String hello() {
		return "Hello from the actuator";
	}
	
}
