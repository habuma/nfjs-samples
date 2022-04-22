package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloK8sApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloK8sApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner delayer(ApplicationContext ctx) {
		return args -> {
			AvailabilityChangeEvent.publish(
					ctx, ReadinessState.REFUSING_TRAFFIC);
			
			
			Thread.sleep(30000);

			AvailabilityChangeEvent.publish(
					ctx, ReadinessState.ACCEPTING_TRAFFIC);
		};
	}

}
