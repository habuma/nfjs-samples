package habuma;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="greeting")
public class GreetingProps {
  
  private String hello;
  private String goodbye;
  
  public String getHello() {
    return hello;
  }
  
  public void setHello(String hello) {
    this.hello = hello;
  }
  
  public String getGoodbye() {
    return goodbye;
  }
  
  public void setGoodbye(String goodbye) {
    this.goodbye = goodbye;
  }
  
}
