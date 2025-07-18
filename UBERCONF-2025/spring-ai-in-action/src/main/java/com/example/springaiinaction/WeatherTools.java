package com.example.springaiinaction;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class WeatherTools {

  @Tool(name="getWeather",
        description = "Get the weather for a given zipcode")
  public Weather getWeather(
      @ToolParam(description = "The zipcode to get the weather for") String zipcode) {
    System.err.println(" --- > Getting weather for zipcode: " + zipcode);
    String temperature = "160F";
    String conditions = "Raining cats, dogs, and frogs";
    return new Weather(zipcode, temperature, conditions);
  }

}
