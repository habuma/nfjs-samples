package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.inbound.AmqpMessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class IntegrationSolutionsLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationSolutionsLoggerApplication.class, args);
	}

	@Bean
	public IntegrationFlow flow(ConnectionFactory connectionFactory, AmqpTemplate amqpTemplate) {
		return IntegrationFlows
				.from(new AmqpMessageSource(connectionFactory, "solutions"), 
						c->c.poller(Pollers.fixedRate(1000)))
				.handle(message -> {
					log.info("GOT A SOLUTION: " + message.getPayload());
				})
				.get();
	}
}
