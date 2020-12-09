package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class ArchconfGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchconfGatewayApplication.class, args);
	}
	
	@Bean
	public KeyResolver userKeyResolver() {
		return exchange -> Mono.just("habuma");
	}

//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//			.route("start", r->
//				r.path("/**")
//				 .filters(f -> f.addRequestHeader("X-ArchConf", "December 2020"))
//				 .uri("http://localhost:8080"))
//			.build();
//	}
	
}
