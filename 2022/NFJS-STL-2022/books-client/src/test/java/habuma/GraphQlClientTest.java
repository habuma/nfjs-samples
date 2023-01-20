package habuma;

import org.junit.jupiter.api.Test;
import org.springframework.graphql.client.HttpGraphQlClient;

public class GraphQlClientTest {

	@Test
	public void fetchStuff() throws Exception {
				
		HttpGraphQlClient qlClient = HttpGraphQlClient.builder()
			.webClient(wcBuilder -> {
				wcBuilder
					.baseUrl("http://localhost:8080/graphql");
			})
			.build();
		
		qlClient.document("{hello}")
			.retrieve("hello")
			.toEntity(String.class)
			.subscribe(greeting -> {
				System.out.println("GREETING: " + greeting);
			});
		
		qlClient.document("{books{isbn title}}")
			.retrieve("books")
			.toEntity(Book[].class)
			.subscribe(books -> {
				for (Book book : books) {
					System.out.println("BOOK : " + book.getTitle() + " : " + book.getIsbn());					
				}
			});
		
		Thread.sleep(10000);
	}
	
}
