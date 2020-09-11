package habuma;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledBean {

	@Scheduled(fixedDelay = 5000)
	public void doSomething() {
		System.out.println("DOING SOMETHING");
	}
	
}
