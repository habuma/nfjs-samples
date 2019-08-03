package habuma;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix="greeting")
public class GreetingProps {

	private String who;
	
	private String where = "Des Moines";
	
}
