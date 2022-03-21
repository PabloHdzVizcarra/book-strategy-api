package jvm.pablohdz.bookstrategyapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
  private String id;

  private String name;

  private Double price;

  private String category;
}
