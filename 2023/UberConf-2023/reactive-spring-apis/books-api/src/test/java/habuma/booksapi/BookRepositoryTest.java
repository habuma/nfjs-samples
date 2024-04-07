package habuma.booksapi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DataJdbcTest
public class BookRepositoryTest {

    @Container
    @ServiceConnection
    static JdbcDatabaseContainer postgreSQLContainer =
            new PostgreSQLContainer("postgres:latest")
                    .withDatabaseName("book")
                    .withUsername("sa")
                    .withPassword("sa");

    @Autowired
    BookRepository repo;

    @Test
    public void test() {
        System.out.println("1");

        Assertions.assertThat(repo.count()).isEqualTo(2L);

        Book savedBook = repo.save(new Book(
                null,
                "1234567890",
                "Test Book",
                "Test Author"));

        Assertions.assertThat(repo.count()).isEqualTo(3L);

        Assertions.assertThat(savedBook.id()).isNotNull();

        Book foundBook = repo.findByIsbn("1122334455");

        Assertions.assertThat(foundBook.title())
                .isEqualTo("Knitting with Dog Hair");
        Assertions.assertThat(foundBook.author())
                .isEqualTo("Kendall Crolius");
    }

    @Test
    public void test2() {
        System.out.println("2");
        Assertions.assertThat(repo.count()).isEqualTo(2L);
    }
}
