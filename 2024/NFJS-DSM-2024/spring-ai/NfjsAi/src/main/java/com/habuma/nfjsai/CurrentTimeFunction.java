package com.habuma.nfjsai;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component("timeFunction")
@Description("Get the current time given a timezone")
public class CurrentTimeFunction
    implements Function<CurrentTimeRequest, CurrentTimeResponse> {

  @Override
  public CurrentTimeResponse apply(CurrentTimeRequest currentTimeRequest) {
    System.err.println(" ---> currentTimeRequest: " + currentTimeRequest);
    return new CurrentTimeResponse("1:32 PM");
  }

}
