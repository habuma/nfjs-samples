package habuma.books;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledThings {

	@Scheduled(fixedRate=5000)
	public void doSomething() {
		System.out.println(System.currentTimeMillis());
	}
	
}
