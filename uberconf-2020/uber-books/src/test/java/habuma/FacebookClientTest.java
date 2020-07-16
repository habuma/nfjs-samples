package habuma;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
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

@RestClientTest(components = FacebookClient.class)
public class FacebookClientTest {

	//
	// Post session fix: Fixed by using RestTemplateBuilder in the client
	//
	
	@Autowired
	FacebookClient fb;
	
	@Autowired
	MockRestServiceServer server;
	
	@Value("classpath:/fbme.json")
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
		String me = fb.getProfile();
		System.out.println("ME:  " + me);
	}
	
}
