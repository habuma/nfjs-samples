package habuma;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthIndicator 
	implements HealthIndicator {

	@Override
	public Health health() {
		double number = Math.random();
		
		if (number > 0.5) {
			return Health.up()
					.withDetail("Reason", "The value was big enough: " + number)
					.build();
		}
		
		return Health.down()
				.withDetail("Reason", "The value is too small:  " + number)
				.build();
	}
	
}
