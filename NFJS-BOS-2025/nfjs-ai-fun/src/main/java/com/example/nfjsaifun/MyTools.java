package com.example.nfjsaifun;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class MyTools {

  @Tool(name="getWeather", description="Get the weather for a given zip code")
  public Weather getWeatherForZipCode(
      @ToolParam(description="The zip code to get the weather for") String zipcode) {
    return new Weather("Raining Cats and Dogs", "51.3F");
  }

}
