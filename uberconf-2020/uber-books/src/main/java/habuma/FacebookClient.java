package habuma;

import java.net.URI;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FacebookClient {
	
	private RestTemplate rest;

	public FacebookClient(RestTemplateBuilder rtBuilder) {
		this.rest = rtBuilder.build();
	}

	public String getProfile() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth("MOCK_TOKEN");
		RequestEntity<Void> requestEntity = new RequestEntity<Void>(headers, HttpMethod.GET, URI.create("https://graph.facebook.com/me"));
		return rest.exchange(requestEntity, String.class).getBody();
	}
	
	public RestTemplate getRestTemplate() {
		return rest;
	}
}
