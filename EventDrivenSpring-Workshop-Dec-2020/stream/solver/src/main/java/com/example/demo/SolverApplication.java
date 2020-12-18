package com.example.demo;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	QuadraticSolver solver;

	@Bean
	public Function<Equation, Solution> solve() {
		return equation -> {
			return solver.solve(equation);
		};
	}
	
}
