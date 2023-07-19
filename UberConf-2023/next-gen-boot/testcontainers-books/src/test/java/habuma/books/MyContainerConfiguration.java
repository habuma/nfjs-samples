package habuma.books;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

public class MyContainerConfiguration {
    @Bean
    @ServiceConnection
    public JdbcDatabaseContainer postgreSQLContainer() {
        return new PostgreSQLContainer("postgres:latest")
                .withDatabaseName("books")
                .withUsername("sa")
                .withPassword("sa");
    }
}
