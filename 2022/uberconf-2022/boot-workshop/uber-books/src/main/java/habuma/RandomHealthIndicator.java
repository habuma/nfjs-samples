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
		
		if (value > 0.5) {
			return Health.up()
					.withDetail("reason", "The value is sufficiently large: " + value)
					.build();
		}
		
		return Health.down()
				.withDetail("reason", "The value was too small: " + value)
				.build();
	}
}
