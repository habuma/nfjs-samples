package com.example.springbooks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/themeparks")
public class ThemeParksController {

  private final ThemeParksApiClient2 themeParkApiClient;

  public ThemeParksController(ThemeParksApiClient2 themeParkApiClient) {
    this.themeParkApiClient = themeParkApiClient;
  }

  @GetMapping("/destinations")
  public List<Destination> getDestinations() {
    return themeParkApiClient.getDestinations().destinations();
  }

}
