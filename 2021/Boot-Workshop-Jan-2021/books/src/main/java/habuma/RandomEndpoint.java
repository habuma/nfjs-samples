package habuma;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "random", enableByDefault = true)
public class RandomEndpoint {

	@ReadOperation
	public String hello() {
		return "Hello from the endpoint";
	}
	
}
