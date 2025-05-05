package com.habuma.functionsexample;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Description("Get the current time in a specified time zone.")
public class CurrentTimeFunction implements Function<CurrentTimeIn, CurrentTimeOut> {
  @Override
  public CurrentTimeOut apply(CurrentTimeIn currentTimeIn) {
    System.err.println("Getting the current time in " + currentTimeIn.timeZone());
    return new CurrentTimeOut("12:34 PM"); // TODO: Actually get the current time in the specified city
  }
}
