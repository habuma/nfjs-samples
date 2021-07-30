package books;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class LegacySystemHealthIndicator 
	implements HealthIndicator {

	@Override
	public Health health() {
		double random = Math.random();
		
		if (random > 0.5) {
			return Health.up()
					.withDetail("reason", "The value is large enough: " + random)
					.build();
		}
		
		// DOWN
		return Health.down()
					.withDetail("reason", "The value is too small: " + random)
					.build();
	}
	
}
