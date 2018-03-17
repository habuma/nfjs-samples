package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(BookRepository repo) {
		return (args) -> {
			repo.save(new Book("1234567890", "Spring in Action", "Craig Walls"));
			repo.save(new Book("9876543211", "Making Java Groovy", "Ken Kousen"));
		};
	}
	
	@Bean
	public HealthIndicator random() {
		return () -> {
			double random = Math.random();
			
			if (random > 0.5) {
				return Health
					.up()
					.withDetail("Status", "The value " + random + " is plenty big.")
					.withDetail("Time", System.currentTimeMillis())
					.build();
			}
			
			return Health
					.down()
					.withDetail("REASON", "The value is too low.")
					.build();
		};
	}
}
