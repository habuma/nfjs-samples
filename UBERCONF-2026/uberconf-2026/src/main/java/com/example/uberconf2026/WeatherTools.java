package com.example.uberconf2026;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class WeatherTools {

  @Tool(name = "get-weather-for-zipcode",
  description = "Get the weather for a given zipcode")
  public WeatherConditions getWeatherForZipcode(
      @ToolParam(description = "The zipcode to get the weather for")
      String zipcode) {
    System.err.println("GETTING WEATHER FOR ZIPCODE: " + zipcode);
    return new WeatherConditions(zipcode, "Raining cats and dogs", "77F");
  }

}
