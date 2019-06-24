package habuma;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		double number = Math.random();
		
		if (number > 0.5) {
			return Health.up()
					.withDetail("reason", "The value was large enough: " + number)
					.build();
		}
		
		return Health.down()
				.withDetail("reason", "The value was too small: " + number)
				.build();
	}
	
}
