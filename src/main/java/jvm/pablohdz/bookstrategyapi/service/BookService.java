package jvm.pablohdz.bookstrategyapi.service;

import jvm.pablohdz.bookstrategyapi.component.AudioReaderStrategy;
import jvm.pablohdz.bookstrategyapi.component.ContextReader;
import jvm.pablohdz.bookstrategyapi.component.DigitalReaderStrategy;
import jvm.pablohdz.bookstrategyapi.component.PhysicsReaderStrategy;
import jvm.pablohdz.bookstrategyapi.component.ReaderStrategyEnum;
import jvm.pablohdz.bookstrategyapi.dto.Book;
import jvm.pablohdz.bookstrategyapi.dto.BuyBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final ContextReader contextReader;
  private final DigitalReaderStrategy digitalReaderStrategy;
  private final PhysicsReaderStrategy physicsReaderStrategy;
  private final AudioReaderStrategy audioReaderStrategy;

  @Autowired
  public BookService(ContextReader contextReader,
      DigitalReaderStrategy digitalReaderStrategy,
      PhysicsReaderStrategy physicsReaderStrategy,
      AudioReaderStrategy audioReaderStrategy) {
    this.contextReader = contextReader;
    this.digitalReaderStrategy = digitalReaderStrategy;
    this.physicsReaderStrategy = physicsReaderStrategy;
    this.audioReaderStrategy = audioReaderStrategy;
  }

  public Book buyBook(BuyBookRequest buyBookRequest) {
    String typeReader = buyBookRequest.getTypeReader();
    String nameBook = buyBookRequest.getNameBook();
    ReaderStrategyEnum typeBook = ReaderStrategyEnum.fromString(typeReader);
  
    return getBook(nameBook, typeBook);
  }
  
  private Book getBook(String nameBook, ReaderStrategyEnum typeBook) {
    Book book = new Book();
    
    switch (typeBook) {
      case AUDIO_READER:
        {
          contextReader.setReaderStrategy(audioReaderStrategy);
          book = contextReader.executeStrategy(nameBook);
          break;
        }
      case DIGITAL_READER:
        {
          contextReader.setReaderStrategy(digitalReaderStrategy);
          book = contextReader.executeStrategy(nameBook);
          break;
        }
      case PHYSICS_READER:
        {
          contextReader.setReaderStrategy(physicsReaderStrategy);
          book = contextReader.executeStrategy(nameBook);
          break;
        }
    }
    return book;
  }
}
