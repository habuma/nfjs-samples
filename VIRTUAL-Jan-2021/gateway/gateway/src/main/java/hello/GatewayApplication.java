package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return
				builder.routes()
					.route("yahoo", r->
						r.path("/oohay")
						.filters(f -> f.rewritePath(".*", "/"))
						.uri("https://yahoo.com"))
					.build();
	}
	
	@Bean
	public KeyResolver userKeyResolver() {
		return exchange -> Mono.just("habuma");
	}
	
}
