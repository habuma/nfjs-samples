package habuma;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebFluxSecurity
public class SecurityConfig {

//	@Bean
//	public ReactiveUserDetailsService userDetailsService() {
//		return new ReactiveUserDetailsService() {
//			
//			@Bean
//			public SecurityWebFilterChain securityWebFilterChain(
//					ServerHttpSecurity http) {
//				return
//						http
//						.authorizeExchange()
//						.pathMatchers("/hello").hasAuthority("ROLE_USER")
//						.anyExchange().permitAll()
//						.and()
//						.build();
//			}
//			
//			@Override
//			public Mono<UserDetails> findByUsername(String username) {
//				User user = new User(
//						"habuma", 
//						passwordEncoder().encode("password"), 
//						Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
//				return Mono.just(user);
//			}
//		};
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		System.err.println("CREATING PASSWORD ENCODER");
////		return NoOpPasswordEncoder.getInstance();
//		return new BCryptPasswordEncoder();
//	}
	
}
