package habuma.books;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ThingScheduler {

	@Scheduled(fixedRate = 5000)
	public void tick() {
		System.out.println("------>>>  " + System.currentTimeMillis());
	}
	
}
