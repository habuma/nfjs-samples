package habuma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="greeting")
public class GreetingProps {

	private String message = "Hello, world!";
	private int random;
}
