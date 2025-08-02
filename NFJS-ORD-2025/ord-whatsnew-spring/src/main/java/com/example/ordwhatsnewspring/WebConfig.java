package com.example.ordwhatsnewspring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void configureApiVersioning(ApiVersionConfigurer configurer) {
    configurer
//        .useRequestHeader("X-Api-Version")
//        .useRequestParam("version")
        .usePathSegment(0)
        .setDefaultVersion("1.1");
  }
}
