package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class MyInfoContributor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		Map<String, Object> other = new HashMap<>();
		other.put("A", "B");
		other.put("C", "D");
		
		builder
			.withDetail("time", System.currentTimeMillis())
			.withDetail("other", other)
			.withDetails(other)
			.withDetail("book", new Book("1234567890", "Spring in Action", "Craig Walls"))
			.build();
	}

}
