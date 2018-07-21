package hellosayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
@EnableHystrix
public class HelloSayerApplication {
	
	@Autowired
	private HelloSayer helloSayer;

	public static void main(String[] args) {
		SpringApplication.run(HelloSayerApplication.class, args);
	}

//	@ServiceActivator(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public String transform(String payload) {
		return helloSayer.sayHelloTo(payload);
	}
		
}
