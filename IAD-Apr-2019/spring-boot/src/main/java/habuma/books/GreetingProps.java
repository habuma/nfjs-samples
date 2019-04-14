package habuma.books;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "greeting")
public class GreetingProps {
	
	private String message;
	
	private String message2;
	
	private String place;
	
}
