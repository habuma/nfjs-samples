package habuma;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
	
	@Autowired
	MeterRegistry meterRegistry;

	@GetMapping("/hello")
	public String hello() throws Exception {
		
		meterRegistry.counter("habuma", "hello", "count").increment();
		
//		for(int i=0;i<60;i++) {
//			log.debug("SLEEPING: " + i);
//			Thread.sleep(1000L);
//		}
		
		return "Hello world!";
	}
	
}
