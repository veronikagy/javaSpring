package ru.mmtr.dictionary.domain;

import lombok.Getter;
import ru.mmtr.dictionary.exceptions.UnknownDictionaryTypeException;

@Getter
public enum DictionaryFileEnum {
    DICTIONARY1(1, new ValidationRule("[a-zA-Z]{4}")),
    DICTIONARY2(2, new ValidationRule("[0-9]{5}"));

    private final ValidationRule dictionaryPattern;

    private final Integer dictionaryNumber;

    DictionaryFileEnum(Integer dictionaryNumber, ValidationRule dictionaryPattern) {
        this.dictionaryNumber = dictionaryNumber;
        this.dictionaryPattern = dictionaryPattern;
    }

    public static DictionaryFileEnum resolveDictionaryNumber(int dictionary_number) {
        return switch (dictionary_number) {
            case (1) -> DictionaryFileEnum.DICTIONARY1;
            case (2) -> DictionaryFileEnum.DICTIONARY2;
            default -> throw new UnknownDictionaryTypeException("Словаря с номером "
                    + dictionary_number + " не существует.");
        };
    }
}
