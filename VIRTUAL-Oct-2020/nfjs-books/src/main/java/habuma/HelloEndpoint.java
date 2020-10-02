package habuma;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "hello")
public class HelloEndpoint {

	@ReadOperation
	public String hello() {
		// ...do something cool...
		return "Hello";
	}
	
}
