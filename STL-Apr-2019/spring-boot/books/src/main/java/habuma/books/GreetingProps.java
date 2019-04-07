package habuma.books;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="greeting")
@Data
public class GreetingProps {

	private String message = "Hello world";
	
}
