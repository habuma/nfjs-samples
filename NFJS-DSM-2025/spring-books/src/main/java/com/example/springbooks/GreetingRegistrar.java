package com.example.springbooks;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class GreetingRegistrar implements BeanRegistrar {

  @Override
  public void register(BeanRegistry registry, Environment env) {
    registry.registerBean(GreetingService.class);
  }

}
