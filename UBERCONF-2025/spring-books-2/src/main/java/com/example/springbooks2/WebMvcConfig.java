package com.example.springbooks2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Value("${myapp.version:1.0.0}")
  String appVersion;

  @Override
  public void configureApiVersioning(ApiVersionConfigurer configurer) {
    configurer
        .useRequestParam("version")
        .useRequestHeader("X-API-Version")
        .usePathSegment(0)
        .setDefaultVersion(appVersion);
  }
}
