package com.example.demo;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class FluxTest {

	@Test
	public void flux() {
		
		Flux<CounterTick> tickFlux = 
				Flux.interval(Duration.ofSeconds(1))
					.map(l -> new CounterTick(l))
					.doOnNext(t -> {
						System.out.println(t.tick());
					});
		
		tickFlux.subscribe();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
