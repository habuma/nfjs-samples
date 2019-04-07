package habuma.books;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class DemoInfoContributor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("session-name", "Spring Boot Actuator")
		.withDetail("time", System.currentTimeMillis());
	}

}
