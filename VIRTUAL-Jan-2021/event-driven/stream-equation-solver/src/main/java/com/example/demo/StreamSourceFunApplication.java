package com.example.demo;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

@SpringBootApplication
public class StreamSourceFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamSourceFunApplication.class, args);
	}
	
	@Bean
	public Function<Message<Equation>, Solution> solve(QuadraticSolver solver) {
		return equation -> {
			MessageHeaders headers = equation.getHeaders();
			System.out.println("HEADERS:  " + headers);
			return solver.solve(equation.getPayload());
		};
	}

}
