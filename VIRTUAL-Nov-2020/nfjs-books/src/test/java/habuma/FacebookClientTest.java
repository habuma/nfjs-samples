package habuma;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

@RestClientTest(FacebookClient.class)
public class FacebookClientTest {
 	
 	@Autowired
 	FacebookClient fb;
 	
 	@Autowired
 	MockRestServiceServer server;
 	 
 	@Value("classpath:/habuma/fbme.json")
 	Resource meJson;
  
 	@BeforeEach
 	public void setup() throws Exception {
 		this.server.expect(method(HttpMethod.GET))
 			.andExpect(requestTo("https://graph.facebook.com/me"))
 			.andExpect(header("Authorization", "Bearer MOCK_TOKEN"))
 			.andRespond(withSuccess().body(meJson).contentType(MediaType.APPLICATION_JSON));
 	}
 	 
 	@Test
 	public void testGetMe() throws Exception {
 		FacebookProfile me = fb.getMe("MOCK_TOKEN");
 		assertThat(me.getId()).isEqualTo("fakeId01234");
 		assertThat(me.getName()).isEqualTo("Test User");
 	}
}
