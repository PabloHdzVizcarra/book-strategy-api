package jvm.pablohdz.bookstrategyapi.component;

import jvm.pablohdz.bookstrategyapi.dto.Book;

public interface ReaderStrategy {

  Book execute(String nameBook);
}
