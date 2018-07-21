package greetinglogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.handler.LoggingHandler;

@SpringBootApplication
@EnableBinding(Sink.class)
public class GreetingLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingLoggerApplication.class, args);
	}
	
    @Bean
	@ServiceActivator(inputChannel = Sink.INPUT)
	public LoggingHandler logSinkHandler() {
		LoggingHandler loggingHandler = new LoggingHandler("INFO");
		loggingHandler.setLoggerName(GreetingLoggerApplication.class.getName());
		return loggingHandler;
	}
}
