package habuma;

import java.net.URI;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class FacebookClient {
	
 	private RestOperations rest;
 	public FacebookClient(RestTemplateBuilder rtBuilder) {
 		this.rest = rtBuilder.build();
 	}
 	
 	public FacebookProfile getMe(String accessToken) {
 		HttpHeaders headers = new HttpHeaders();
 		headers.add("Authorization", "Bearer " + accessToken);
 		RequestEntity<String> requestEntity = new RequestEntity<>(
 				headers, 
 				HttpMethod.GET, URI.create("https://graph.facebook.com/me"));
 		ResponseEntity<FacebookProfile> responseEntity = rest.exchange( 
 				requestEntity, 
 				FacebookProfile.class);
 		return responseEntity.getBody();
 	}
 	
}