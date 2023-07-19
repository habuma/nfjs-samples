package habuma.books;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer postgreSQLContainer =
            new PostgreSQLContainer("postgres:latest")
                    .withDatabaseName("book")
                    .withUsername("sa")
                    .withPassword("sa");

    @Autowired
    BookRepository repo;

    @Test
    public void test() {
        Assertions.assertThat(repo.count()).isEqualTo(2L);
        Book savedBook = repo.save(new Book(

                "1234567890",
                "Test Book",
                "Test Author"));

        Assertions.assertThat(repo.count()).isEqualTo(3L);

        Assertions.assertThat(savedBook.getId()).isNotNull();

        Book foundBook = repo.findByIsbn("1122334455");

        Assertions.assertThat(foundBook.getTitle())
                .isEqualTo("Knitting with Dog Hair");
        Assertions.assertThat(foundBook.getAuthor())
                .isEqualTo("Kendall Crolius");
    }

}