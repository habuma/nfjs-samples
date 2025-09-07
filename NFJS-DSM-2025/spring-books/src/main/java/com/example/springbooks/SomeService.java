package com.example.springbooks;

public class SomeService {

  private final String message;

  public SomeService(String message) {
    this.message = message;
  }

  public void doSomething() {
    System.out.println(message);
  }

}
