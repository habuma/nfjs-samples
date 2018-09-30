package habuma;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthIndicator 
	implements HealthIndicator {

	@Override
	public Health health() {
		double r = Math.random();
		
		if (r > 0.5) {
			// up
			return Health.up()
					.withDetail("reason", "The number is big enough: " + r)
					.withDetail("other", "Hi there")
					.build();
		} else {
			// down
			return Health.down()
					.withDetail("reason", "The number is too small: " + r)
					.build();
		}
	}
	
}
