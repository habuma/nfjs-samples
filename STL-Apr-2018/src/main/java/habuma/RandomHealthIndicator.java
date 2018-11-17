package habuma;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthIndicator 
		implements HealthIndicator {

	@Override
	public Health health() {
		double value = Math.random();
		if (value < 0.5) {
			return Health.down()
					.withDetail("reason", "The value was too low: " + value)
					.build();
		}
		
		return Health.up()
				.withDetail("status", "The value is large enough")
				.build();
	}
	
}
