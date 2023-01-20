package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class ReactiveTests {

	@Test
	public void toUpperCase() throws Exception {
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("cherry");
		fruits.add("date");
		
		Flux.fromIterable(fruits)
			.flatMap(f -> {
				return Flux.just(f.toUpperCase(), f.toLowerCase(), f)
						.map(f1 -> {
							double random = Math.random();
							System.err.println("THREAD: " + Thread.currentThread().getId());
							try {
								Thread.sleep(Math.round(random*100));
							} catch (Exception e) {}
							return f1.toLowerCase();
						})
						.subscribeOn(Schedulers.parallel());
			})
			.doOnNext(f -> {
				System.out.println("Here's a fruit: " + f);
			})
			.subscribe();
		
			Thread.sleep(10000);
		
	}
	
}
