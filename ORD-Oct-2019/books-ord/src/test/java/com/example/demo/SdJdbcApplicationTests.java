package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "ord")
class SdJdbcApplicationTests {

	@Autowired
	GreetingProps props;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void greetingIsSet() {
		Assertions.assertNotNull(props.getMessage());
		Assertions.assertEquals("Hello, Chicago!", props.getMessage());
	}

}
