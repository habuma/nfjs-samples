package habuma;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		
		double random = Math.random();
		
		if (random > 0.5) {
			return Health.up()
					.withDetail("Reason", "The value was sufficiently large: " + random)
					.build();
		}
		
		return Health.down()
					.withDetail("Reason", "The value was too small:  " + random)
					.build();
	}
	
}
