package com.example.springbooks;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ThemeParkApiClient {

  private final RestClient restClient;

  public ThemeParkApiClient(RestClient.Builder clientBuilder) {
    this.restClient = clientBuilder
        .baseUrl("https://api.themeparks.wiki/v1")
        .build();
  }


  List<Destination> getDestinations() {
    return restClient.get()
        .uri("/destinations")
        .retrieve()
        .body(Destinations.class)
        .destinations();
  }

}
