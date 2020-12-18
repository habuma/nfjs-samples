package com.example.demo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.SendTo;


@SpringBootApplication
public class SolverApplication {

	private static final Logger logger = LoggerFactory.getLogger(SolverApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SolverApplication.class, args);
	}

	@Autowired
	QuadraticSolver solver;
	
	@RabbitListener(queues = "equations")
	@SendTo("solutions")
	public Solution handleMessage(Equation equation) {
		return solver.solve(equation);
	}
	
}
