package habuma.books;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.awt.Point;

import org.springframework.boot.actuate.info.Info.Builder;

@Component
public class MyInfoContributor
	implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		Point p = new Point(100, 200);
		
		
		builder
			.withDetail("time", System.currentTimeMillis())
			.withDetail("point", p);
	}
	
}
