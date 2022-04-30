package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import reactor.core.publisher.Mono;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
    	return http
    			.authorizeExchange()
    				.pathMatchers("/goodbye").hasAnyRole("USER")
    				.anyExchange().permitAll()
    			.and()
    				.httpBasic()
    			.and()
    			.build();
    }
	
	@Bean
	public ReactiveUserDetailsService userDetails(PasswordEncoder encoder) {
		return username -> {
			if (username.equals("habuma")) {
				List<GrantedAuthority> auths = new ArrayList<>();
				auths.add(new SimpleGrantedAuthority("ROLE_USER"));
				return Mono.just(new User(username, encoder.encode("password"), auths));
			}
			return Mono.empty();
		};
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
