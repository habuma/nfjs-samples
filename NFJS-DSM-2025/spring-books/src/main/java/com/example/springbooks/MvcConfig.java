package com.example.springbooks;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  @Override
  public void configureApiVersioning(ApiVersionConfigurer configurer) {
    configurer
        .useRequestHeader("X-API-Version")
//        .useQueryParam("version")
//        .usePathSegment(0)
        .setDefaultVersion("2.0");
  }
}
