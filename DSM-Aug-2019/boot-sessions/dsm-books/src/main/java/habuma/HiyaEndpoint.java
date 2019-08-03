package habuma;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "hiya", enableByDefault = true)
public class HiyaEndpoint {

	@ReadOperation
	public String hiya() {
		return "Hiya!";
	}
	
}
