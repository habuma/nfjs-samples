package com.example.springaiworkshop;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class WeatherTools {

  @Tool(name="getWeatherForZipCode",
      description="Get the current weather for a given zip code. " +
          "The zip code should be a five digit string.")
  public Weather getWeatherForZipCode(
      @ToolParam(description = "The zipcode to get weather for") String zipCode) {
    System.err.println("Fetching weather for zip code: " + zipCode);
    return new Weather(zipCode, "125F", "Raining cats and dogs.");
  }

}
