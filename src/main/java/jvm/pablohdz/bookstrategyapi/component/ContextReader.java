package jvm.pablohdz.bookstrategyapi.component;

import jvm.pablohdz.bookstrategyapi.dto.Book;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ContextReader {
  private ReaderStrategy readerStrategy;
  
  public void setReaderStrategy(ReaderStrategy readerStrategy) {
    this.readerStrategy = readerStrategy;
  }
  
  public Book executeStrategy(String name) {
    return readerStrategy.execute(name);
  }
}
