package habuma.reactivebooks;

import org.springframework.beans.factory.annotation.Value;

public interface SimpleBook {

    String getIsbn();
    String getTitle();

    @Value("#{target.author.split(' ')[0]}")
    String getAuthorFirstName();

    @Value("#{target.author.split(' ')[1]}")
    String getAuthorLastName();

}
