package habuma;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.stereotype.Component;

@Component
public class RandomInfoContributor 
	implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("random-number", Math.random());
		
		Book book = new Book("1234567890", "Knitting with Dog Hair", "Kendall Crolius");
		builder.withDetail("dog-hair-book", book);
		
	}
	
}
