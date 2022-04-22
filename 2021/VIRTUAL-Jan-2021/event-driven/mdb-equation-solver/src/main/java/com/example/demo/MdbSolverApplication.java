package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
public class MdbSolverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdbSolverApplication.class, args);
	}
	
	@Autowired
	QuadraticSolver solver;

	@RabbitListener(queues = "equations")
	@SendTo("solutions")
	public Solution handleMessage(Equation equation) {
		return solver.solve(equation);
	}
	
}
