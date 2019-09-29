package habuma;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledThings {

	@Scheduled(fixedRate = 1000)
	public void doSomething() {
		System.out.println("DOING SOMETHING");
	}
	
}
