package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QuadraticController {
	
	private final EmitterProps props;
	private final RabbitTemplate rabbit;

	@PostMapping("/quad")
	public Equation postEquation(@RequestBody Equation equation) {
		rabbit.convertAndSend(props.getQueueName(), equation);
		return equation;
	}
	
}
