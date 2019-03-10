package habuma;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthIndicator implements HealthIndicator{

	@Override
	public Health health() {
		double value = Math.random();
		
		if (value > 0.5) {
			return Health
					.up()
					.withDetail("value", "The value is " + value)
					.build();
		} else if (value > 0.3) {
			return Health.unknown()
					.withDetail("value", "The value is unknown")
					.build();
		} else if (value > 0.2) {
			return Health.outOfService()
					.withDetail("value", "The value is out of service: " + value)
					.withDetail("time", System.currentTimeMillis())
					.build();
		}
		
		return Health.down()
				.withDetail("reason", "The value is really low: " + value)
				.build();
	}
	
}
