package com.example.springbooks2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(group="themeparks", basePackageClasses = ThemeParkApi.class)
public class HttpClientConfig {

}
