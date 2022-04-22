package com.example.demo;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivenessReadinessController {

	private ApplicationContext applicationContext;

	public LivenessReadinessController(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	@PostMapping("/notready")
	public String notReady() {
		AvailabilityChangeEvent.publish(
				applicationContext, ReadinessState.REFUSING_TRAFFIC);
		return "notready";
	}

	@PostMapping("/ready")
	public String ready() {
		AvailabilityChangeEvent.publish(
				applicationContext, ReadinessState.ACCEPTING_TRAFFIC);
		return "ready";
	}

	@PostMapping("/alive")
	public String alive() {
		AvailabilityChangeEvent.publish(
				applicationContext, LivenessState.CORRECT);
		return "alive";
	}

	@PostMapping("/dead")
	public String dead() {
		AvailabilityChangeEvent.publish(
				applicationContext, LivenessState.BROKEN);
		return "dead";
	}

}
