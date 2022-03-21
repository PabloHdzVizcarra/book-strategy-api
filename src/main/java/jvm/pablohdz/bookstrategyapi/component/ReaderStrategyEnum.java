package jvm.pablohdz.bookstrategyapi.component;

public enum ReaderStrategyEnum {
  DIGITAL_READER("digital"),
  PHYSICS_READER("physics"),
  AUDIO_READER("audio");

  private final String type;

  ReaderStrategyEnum(String type) {
    this.type = type;
  }

  public static ReaderStrategyEnum fromString(String reader) {
    for (ReaderStrategyEnum readerStrategy : ReaderStrategyEnum.values()) {
      if (readerStrategy.type.equalsIgnoreCase(reader)) return readerStrategy;
    }

    throw new RuntimeException("error parsing the enum");
  }
}
