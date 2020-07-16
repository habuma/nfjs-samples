package habuma;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Endpoint(id = "custom")
public class CustomEndpoint {

	@ReadOperation
	public CustomThing customThing() {
		return new CustomThing("hello", System.currentTimeMillis());
	}
	
	@Data
	public static class CustomThing {
		private final String message;
		private final Long timestamp;
	}
	
}
