package com.example.demo;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class ReactiveFunTests {

	@Test
	public void simple() {
		Flux<String> fruitFlux = 
				Flux.just("Apple", "Banana", "Cherry", "Date");
		
		fruitFlux.map(f -> f.toUpperCase())
			.doOnNext(f -> {
				System.out.println("FRUIT:  " + f);	
			})
			.subscribe();
	}
	
	@Test
	public void notAsSimple() {
		Flux<String> bullsFlux = 
				Flux.just(
						"Michael Jordan", 
						"Scottie Pippen", 
						"Steve Kerr", 
						"Dennis Rodman");
		
		bullsFlux
			.map(player -> {
				String[] split = player.split("\\s");
				return new Player(split[0], split[1]);
			})
			.subscribe(p -> {
				System.out.println(p.getLastName() + ", " + p.getFirstName());
			});
	}
	
	@Test
	public void notAsSimple2() {
		Flux<String> bullsFlux = 
				Flux.just(
						"Michael Jordan", 
						"Scottie Pippen", 
						"Steve Kerr", 
						"Dennis Rodman");
		
		bullsFlux
			.map(player -> {
				String[] split = player.split("\\s");
				return new Player(split[0], split[1]);
			})
			.flatMap(player -> {
				player.setLastName(player.getLastName().toUpperCase());
				return Mono.just(player)
						.doOnNext(p -> {
							long threadId = Thread.currentThread().getId();
							System.err.println("THREAD ID : " + threadId);
							double x = Math.random() * 5;
							long y = (long) x;
							delay(y);
						})
						.subscribeOn(Schedulers.parallel())
						;
			})
			.subscribe(p -> {
				System.out.println(p.getLastName() + ", " + p.getFirstName());
			});
		
		delay(6);
	}
	
	private void delay(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {}
	}
	
}
