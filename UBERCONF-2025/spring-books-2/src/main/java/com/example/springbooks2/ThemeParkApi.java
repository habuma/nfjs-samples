package com.example.springbooks2;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(
    url = "https://api.themeparks.wiki/v1",
    accept="application/json")
public interface ThemeParkApi {
  @GetExchange(url="/destinations")
  DestinationsResponse getDestinations();
}
