package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MdbSolutionLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdbSolutionLoggerApplication.class, args);
	}

	@RabbitListener(queues = "solutions")
	public void handleMessage(Solution solution) {
		log.info("SOLUTION:  " + solution);
	}
}
