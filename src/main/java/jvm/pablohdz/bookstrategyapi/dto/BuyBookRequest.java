package jvm.pablohdz.bookstrategyapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyBookRequest {
  
  @JsonProperty("type_reader")
  private String typeReader;
  
  @JsonProperty("name_book")
  private String nameBook;
}
