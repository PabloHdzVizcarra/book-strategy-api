package jvm.pablohdz.bookstrategyapi.api;

import jvm.pablohdz.bookstrategyapi.dto.Book;
import jvm.pablohdz.bookstrategyapi.dto.BuyBookRequest;
import jvm.pablohdz.bookstrategyapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buy")
public class ReadController {
  private final BookService bookService;
  
  @Autowired
  public ReadController(BookService bookService) {
    this.bookService = bookService;
  }
  
  @PostMapping
  public ResponseEntity<Book> buy(@RequestBody BuyBookRequest buyBookRequest) {
    Book book = bookService.buyBook(buyBookRequest);
    return ResponseEntity.ok(book);
  }
}
