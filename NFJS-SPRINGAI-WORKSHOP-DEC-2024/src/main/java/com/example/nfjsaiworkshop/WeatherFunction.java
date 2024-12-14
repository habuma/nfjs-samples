package com.example.nfjsaiworkshop;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component("weatherFunction")
@Description("Returns the weather forecast for a given zipcode")
public class WeatherFunction implements Function<WeatherIn, WeatherOut> {

    @Override
    public WeatherOut apply(WeatherIn weatherIn) {
        System.err.println("WeatherFunction invoked with " + weatherIn);
        return new WeatherOut("Sunny and 83 degrees");
    }
}
