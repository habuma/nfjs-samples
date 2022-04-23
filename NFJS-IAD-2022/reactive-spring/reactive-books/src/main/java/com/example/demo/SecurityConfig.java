package com.example.demo;

//@EnableWebFluxSecurity
public class SecurityConfig {

//	@Bean
//	public ReactiveUserDetailsService userDetailsService(PasswordEncoder encoder) {
//		return new ReactiveUserDetailsService() {
//			
//			@Override
//			public Mono<UserDetails> findByUsername(String username) {
//				User user = new User(username, encoder.encode("password"), 
//						Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));;
//				return Mono.just(user);
//			}
//		};
//	}
//	
//	@Bean
//	public SecurityWebFilterChain secureWebFilterChain(ServerHttpSecurity http) {
//		return http
//					.authorizeExchange()
//					.pathMatchers("/books/**").hasAnyAuthority("ROLE_ADMIN")
//					.pathMatchers("/**").permitAll()
//					.and()
//					.build();
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
////		return NoOpPasswordEncoder.getInstance();
//		return new BCryptPasswordEncoder();
//	}
	
}
