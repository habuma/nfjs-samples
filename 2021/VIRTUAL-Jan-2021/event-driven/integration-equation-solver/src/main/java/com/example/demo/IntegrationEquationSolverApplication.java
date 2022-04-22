package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.amqp.inbound.AmqpMessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;

@SpringBootApplication
public class IntegrationEquationSolverApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationEquationSolverApplication.class, args);
	}
	
	@Bean
	public IntegrationFlow flow(
			ConnectionFactory connectionFactory, 
			AmqpTemplate amqpTemplate, 
			QuadraticSolver solver) {
		return IntegrationFlows
				.from(new AmqpMessageSource(connectionFactory, "equations"), 
						c->c.poller(Pollers.fixedRate(1000)))
				.<Equation, Solution>transform(equation -> solver.solve(equation))
				.handle(Amqp.outboundGateway(amqpTemplate).routingKey("solutions"))
				.get();
	}

}
