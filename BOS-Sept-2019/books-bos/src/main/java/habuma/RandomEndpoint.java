package habuma;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "random", enableByDefault = true)
public class RandomEndpoint {

	@ReadOperation
	public String random() {
		return "RANDOM VALUE:  " + Math.random();
	}
	
}
