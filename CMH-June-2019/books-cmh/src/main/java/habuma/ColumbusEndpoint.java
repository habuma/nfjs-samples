package habuma;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "columbus", enableByDefault = true)
public class ColumbusEndpoint {

	@ReadOperation
	public String read() {
		return "Hello, Columbus!";
	}
	
	@WriteOperation
	public String write(String who) {
		return "Hello, " + who + "!";
	}
	
}
