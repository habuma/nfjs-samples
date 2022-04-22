package com.example.demo;

import java.util.Optional;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class RabbitFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitFunApplication.class, args);
	}

	@Bean
	public ApplicationRunner appRunner() {
		return args -> {
			while(true) {
				Optional<Solution> optionalEquation = receiveSolution();
				optionalEquation.ifPresent(solution -> {
					log.info("SOLUTION:  " + solution);
				});
			}
		};
	}
	
	@Autowired
	private RabbitTemplate rabbit;
	
	public Optional<Solution> receiveSolution() {
		Solution solution = (Solution) rabbit.receiveAndConvert("solutions", -1);
		return Optional.ofNullable(solution);
	}
	
}
