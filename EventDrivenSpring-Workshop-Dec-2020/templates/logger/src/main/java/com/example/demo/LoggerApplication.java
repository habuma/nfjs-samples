package com.example.demo;

import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggerApplication.class, args);
	}
	
	@Autowired
	RabbitTemplate rabbit;
	
	private Optional<Solution> receiveSolution() {
		Solution solution = (Solution) rabbit.receiveAndConvert("solutions", -1);
		return Optional.of(solution);
	}
	
	@Bean
	public ApplicationRunner appRunner() {
		return args -> {
			while(true) {
				Optional<Solution> optionalSolution = receiveSolution();
				optionalSolution.ifPresent(solution -> {
					log.info("LOGGER GOT A SOLUTION:  " + solution);
				});
			}
		};
	}

}
