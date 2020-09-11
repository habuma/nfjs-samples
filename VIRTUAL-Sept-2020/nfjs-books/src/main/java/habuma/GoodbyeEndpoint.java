package habuma;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="goodbye")
public class GoodbyeEndpoint {

	@ReadOperation
	public String goodbye() {
		return "Goodbye and thanks for attending my session";
	}
}
