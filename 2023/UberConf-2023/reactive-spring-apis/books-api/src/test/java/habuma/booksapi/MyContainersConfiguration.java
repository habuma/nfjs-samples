package habuma.booksapi;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

@Configuration
public class MyContainersConfiguration {

    @Bean
    @ServiceConnection
    public JdbcDatabaseContainer postgreSQLContainer() {
        return new PostgreSQLContainer("postgres:13.2")
                .withDatabaseName("books")
                .withInitScript("schema.sql")
                ;
    }
}
