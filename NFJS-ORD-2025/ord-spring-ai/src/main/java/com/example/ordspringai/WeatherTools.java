package com.example.ordspringai;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class WeatherTools {

  @Tool(name="getWeatherForZipcode",
      description="Gets the weather for a given zipcode.")
  public Weather getWeatherForZipcode(
      @ToolParam(description="Zipcode to get the weather for")
      String zipcode) {
    System.err.println("Fetching weather for zipcode: " + zipcode);
    return new Weather("Raining cats and dogs", "15 degrees Celsius");

  }

}
