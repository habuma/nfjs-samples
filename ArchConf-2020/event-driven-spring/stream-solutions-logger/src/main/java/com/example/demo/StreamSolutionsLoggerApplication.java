package com.example.demo;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class StreamSolutionsLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamSolutionsLoggerApplication.class, args);
	}

	@Bean
	public Consumer<Solution> logSolution() {
		return solution -> {
			log.info("SOLUTION:  " + solution);
		};
	}
}
