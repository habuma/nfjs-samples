package com.example.demo;

import java.util.function.Consumer;

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
	
	@Bean
	public Consumer<Solution> logSolution() {
		return solution -> {
			log.info("CLOUD STREAM LOGGER GOT A SOLUTION:  " + solution);
		};
	}
}
