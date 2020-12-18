package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmitterController {

	private final RabbitTemplate rabbit;
	
	public EmitterController(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}
	
	@PostMapping("/quad")
	public Equation handle(@RequestBody Equation equation) {
		// Change this to "equations.quadratic" for the 
		// Spring Cloud Streams example
		String queueName = "equations"; 
		rabbit.convertAndSend(queueName, equation);
		return equation;
	}
	
}
