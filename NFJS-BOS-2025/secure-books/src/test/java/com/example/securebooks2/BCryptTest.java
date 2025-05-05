package com.example.securebooks2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptTest {

  @Test
  public void testBCrypt() {
    var encoder = new BCryptPasswordEncoder();

    var encoded1 = encoder.encode("password");
    var encoded2 = encoder.encode("password");

    System.err.println(encoded1 + "  ==  " + encoded2);

//    Assertions.assertThat(encoded1).isEqualTo(encoded2);

//    Assertions.assertThat(encoder.matches(encoded1, encoded2)).isTrue();

  }

}
