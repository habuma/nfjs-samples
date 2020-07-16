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
					.withDetail("reason", "The number was sufficiently large:  " + number)
					.withDetail("number", number)
					.build();
		}
		
		return Health.down()
				.withDetail("reason", "Because the number was too low: " + number)
				.build();
	}
	
}
