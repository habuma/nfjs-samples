package habuma;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="greeting")
public class GreetingProps {

	private String who;
	
	public String getWho() {
		return who;
	}
	
	public void setWho(String who) {
		this.who = who;
	}
	
}
