package com.example.springbooks;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.registry.HttpServiceClient;

@HttpServiceClient
@HttpExchange(url="https://api.themeparks.wiki/v1")
public interface ThemeParksApiClient2 {

  @GetExchange(url="/destinations")
  Destinations getDestinations();

}
