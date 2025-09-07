package com.example.springbooks;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GreetingRegistrar.class)
public class GreetingConfig {
}
