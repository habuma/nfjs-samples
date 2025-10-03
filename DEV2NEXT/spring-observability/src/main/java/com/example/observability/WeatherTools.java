package com.example.observability;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class WeatherTools {

  @Tool(name="currentWeather", description="Get the current weather for a given zipcode")
  public Weather currentWeather(String zipcode) {
    return new Weather(zipcode, "Raining cats and dogs", 75);
  }

}
