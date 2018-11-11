package com.example.demo;

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
			// up
			return Health.up()
					.withDetail("reason", "The value is large enough: " + value)
					.withDetail("because", "I said so")
					.build();
		}
		
		//down
		return Health.down()
				.withDetail("reason", "The value is too small: " + value)
				.build();
	}
	
}
