package habuma;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "dummy", enableByDefault = true)
@Component
public class DummyEndpoint {

	private String newValue = "This is just test info.";

	@ReadOperation
	public String dummyInfo() {
		return newValue;
	}
	
	@WriteOperation(produces = "text/plain")
	public String changeSomething(@Selector String newValue) {
		this.newValue = newValue;
		return newValue;
	}
	
	
}
