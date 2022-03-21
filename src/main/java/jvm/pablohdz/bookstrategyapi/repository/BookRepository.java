package jvm.pablohdz.bookstrategyapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import jvm.pablohdz.bookstrategyapi.dto.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
  private final List<Book> repository = new ArrayList<>();
  
  public Book findByName(String name) {
  
    Optional<Book> book = repository.stream()
        .filter(element ->
          Objects.equals(element.getName(), name))
        .findFirst();
    
    return book.orElseThrow(RuntimeException::new);
  }
  
  @Bean
  public void setDataRepository() {
    repository.add(new Book(
        UUID.randomUUID().toString(),
        "Clean Code",
        2.99,
        "code"));
    
    repository.add(new Book(
        UUID.randomUUID().toString(),
        "Design Patterns",
        4.99,
        "code"));
    
    repository.add(new Book(
        UUID.randomUUID().toString(),
        "Introduction To Algorithms",
        6.99,
        "code"));
  }
  
}
