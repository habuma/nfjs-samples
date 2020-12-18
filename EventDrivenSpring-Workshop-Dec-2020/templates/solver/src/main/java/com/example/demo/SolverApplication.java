package com.example.demo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SolverApplication {

	private static final Logger logger = LoggerFactory.getLogger(SolverApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SolverApplication.class, args);
	}

	
	@Autowired
	RabbitTemplate rabbit;
	
	public Optional<Equation> receiveEquation() {
		Equation equation = (Equation) rabbit.receiveAndConvert("equations", -1);
		return Optional.of(equation);
	}
	
	public void sendSolution(Solution solution) {
		rabbit.convertAndSend("solutions", solution);
	}
	
	@Bean
	public ApplicationRunner appRunner(QuadraticSolver solver) {
		return args -> {
			while(true) {
				Optional<Equation> equation = receiveEquation();
				equation.ifPresent(eq -> {
					Solution solution = solver.solve(eq);
					sendSolution(solution);
				});
			}
		};
	}
	
}
