package com.example.springbooks2;

import org.springframework.core.task.TaskDecorator;
import org.springframework.stereotype.Component;

//@Component
public class ScheduledDecorator implements TaskDecorator {
  @Override
  public Runnable decorate(Runnable runnable) {
      System.err.println("ScheduledDecorator.decorate() called");
      runnable.run();
      System.err.println("ScheduledDecorator.decorate() finished");
      return runnable;
  }
}
