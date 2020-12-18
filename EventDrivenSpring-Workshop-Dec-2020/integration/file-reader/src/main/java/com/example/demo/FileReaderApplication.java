package com.example.demo;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.file.dsl.Files;

@SpringBootApplication
public class FileReaderApplication {

	private static final Logger log = LoggerFactory.getLogger(FileReaderApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FileReaderApplication.class, args);
	}
	
	@Bean
	public IntegrationFlow flow(AmqpTemplate amqpTemplate) {
		return IntegrationFlows
				.from(Files.inboundAdapter(new File("/Users/habuma/equations"))
					.patternFilter("*.json"),
					c -> c.poller(Pollers.fixedRate(1000)))
				.transform(Transformers.fromJson(Equation.class))
				.handle(Amqp.outboundGateway(amqpTemplate).routingKey("equations"))
				.get();
	}

}
