package jvm.pablohdz.bookstrategyapi.component;

import static jvm.pablohdz.bookstrategyapi.util.PriceUtils.round;

import jvm.pablohdz.bookstrategyapi.dto.Book;
import jvm.pablohdz.bookstrategyapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhysicsReaderStrategy implements ReaderStrategy {
  private final double COST_TYPE = 2.0;
  private final BookRepository bookRepository;
  
  @Autowired
  public PhysicsReaderStrategy(
      BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
  
  @Override
  public Book execute(String nameBook) {
    Book bookFound = bookRepository.findByName(nameBook);
  
    double price = bookFound.getPrice() * COST_TYPE;
    double priceParsed = round(price, 2);
  
    Book bookResult = new Book();
    bookResult.setName(bookFound.getName());
    bookResult.setCategory(bookFound.getCategory());
    bookResult.setId(bookFound.getId());
    bookResult.setPrice(priceParsed);
    return bookResult;
  }
}
