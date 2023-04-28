package habuma;

import jakarta.persistence.Transient;

public class BookIn extends Book {

  @Transient
  private Long authorId;
  
  public Long getAuthorId() {
    return authorId;
  }
  
  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }
  
}
