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
					.withDetail("Reason", "The value is large enough: " + value)
					.build();
		}
		
		return Health.down()
				.withDetail("reason", "The value is too small: " + value)
				.withDetail("time", "The time is : " + System.currentTimeMillis())
				.build();
	}

}
