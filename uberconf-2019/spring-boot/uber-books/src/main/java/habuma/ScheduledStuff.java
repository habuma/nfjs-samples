package habuma;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ScheduledStuff {

//	@Scheduled(fixedDelay = 5000)
	public void doSomething() {
		log.info("DOING SOMETHING");
	}
	
}
