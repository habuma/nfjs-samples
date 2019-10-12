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
		
		// increased likelihood of a healthy app to avoid frequent ups and downs in
		// the admin
		if (value > 0.1) {
			// healthy
			return Health
					.up()
					.withDetail("reason", "The value was sufficiently large: " + value)
					.build();
		}
		
		// unhealthy
		return Health
				.down()
				.withDetail("reason", "The value was too small:  " + value)
				.build();
	}
	
}
