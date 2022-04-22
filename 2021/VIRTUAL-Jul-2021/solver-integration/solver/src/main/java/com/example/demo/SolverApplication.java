package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.amqp.inbound.AmqpMessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.messaging.handler.annotation.SendTo;


@SpringBootApplication
public class SolverApplication {

	private static final Logger logger = LoggerFactory.getLogger(SolverApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SolverApplication.class, args);
	}

	@Autowired
	QuadraticSolver solver;

	@Bean
	public IntegrationFlow flow(
			ConnectionFactory cf,
			AmqpTemplate amqpTemplate) {
		return IntegrationFlows
				.from(new AmqpMessageSource(cf, "equations"),
						c -> c.poller(Pollers.fixedRate(1000)))
				.<Equation, Solution> transform(equation -> solver.solve(equation))
				.handle(Amqp.outboundGateway(amqpTemplate).routingKey("solutions"))
				.get();
			
	}
	
}
