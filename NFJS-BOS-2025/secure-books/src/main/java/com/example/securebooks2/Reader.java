package com.example.securebooks2;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Reader implements UserDetails {

  private final String username;
  private final String password;
  private final String[] roles;

  public Reader(String username, String password, String... roles) {
    this.username = username;
    this.password = password;
    this.roles = roles;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(roles).stream()
        .map(role -> new SimpleGrantedAuthority(role)).toList();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }
}
