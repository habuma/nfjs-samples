package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestingBooksApplicationTests {

	@Autowired
	Bottle bottle;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void checkBottle() {
		Rum rum = bottle.getRum();
		assertThat(rum.getBrand()).isEqualTo("Bacardi");
	}

}
