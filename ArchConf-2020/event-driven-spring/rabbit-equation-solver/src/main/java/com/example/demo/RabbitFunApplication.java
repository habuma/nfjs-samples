package com.example.demo;

import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitFunApplication.class, args);
	}

	@Bean
	public ApplicationRunner appRunner(QuadraticSolver solver) {
		return args -> {
			while(true) {
				Optional<Equation> optionalEquation = receiveEquation();
				optionalEquation.ifPresent(equation -> {
					Solution solution = solver.solve(equation);
					sendSolution(solution);
				});
				}
		};
	}
	
	@Autowired
	private RabbitTemplate rabbit;
	
	public Optional<Equation> receiveEquation() {
		Equation equation = (Equation) rabbit.receiveAndConvert("equations", -1);
		return Optional.ofNullable(equation);
	}
	
	public void sendSolution(Solution solution) {
		rabbit.convertAndSend("solutions", solution);
	}
	
}
