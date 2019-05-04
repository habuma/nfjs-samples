package habuma.books;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		double value = Math.random();
		if (value > 0.5) {
			return Health.up()
					.withDetail("reason", "The value is big enough: " + value)
					.build();
		} else if (value > 0.2) {
			try {
				throw new RuntimeException("OUCH");
			} catch (RuntimeException e) {
				return Health.down(e).build();
			}
		}
		
		return Health.down()
					.withDetail("reason", "The value is too small:  " + value)
					.build();
	}
	
}
