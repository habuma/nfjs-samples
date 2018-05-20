package habuma;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class LegacyAppHealthIndicator 
		implements HealthIndicator {

	@Override
	public Health health() {
		double legacy = Math.random();
		
		if (legacy > 0.5) {
			return Health
						.up()
						.withDetail("stuff", "The value is big enough: " + legacy)
						.build();
		}
		
		
		return Health.down()
				.withDetail("REASON", "The value is too low: " + legacy)
				.build();
	}
	
}
