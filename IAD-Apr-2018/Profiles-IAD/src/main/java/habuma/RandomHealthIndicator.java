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
		
		if (value > 0.7) {
			return Health.up()
					.withDetail("condition", "The value is big enough: " + value)
					.build();
		} else if (value > 0.4) {
			return Health.outOfService()
					.withDetail("CAUSE", "The value is small-ish: "+ value)
					.build();
		}
		
		return Health.down()
					.withDetail("reason", "The value was too low: " + value)
					.build();
	}
	
}
