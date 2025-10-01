package com.example.trips;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.OAuth2ResourceServerDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .httpBasic(Customizer.withDefaults())
        .formLogin(form -> form.loginPage("/login"))
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/trips/**").hasRole("TRAVELER")
            .requestMatchers(HttpMethod.GET, "/api/trips/**").hasAuthority("SCOPE_trips.read")
            .requestMatchers("/").permitAll()
            .anyRequest().permitAll())
            .oauth2ResourceServer(oauth2-> oauth2.jwt(Customizer.withDefaults()));

    return http.build();
  }

  @Bean
  UserDetailsService userDetailsService(PasswordEncoder encoder) {
    var tony = User.builder()
        .username("tony")
        .password(encoder.encode("ironman"))
        .roles("TRAVELER").build();

    var steve = User.builder()
        .username("steve")
        .password(encoder.encode("captain"))
        .roles("TRAVELER").build();

    var bruce = User.builder()
        .username("bruce")
        .password(encoder.encode("hulk"))
        .roles("TRAVELER").build();

    var thanos = User.builder()
        .username("thanos")
        .password(encoder.encode("madtitan"))
        .roles("TRAVELER", "TITAN").build();

    return new InMemoryUserDetailsManager(List.of(tony, steve, bruce, thanos));
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
