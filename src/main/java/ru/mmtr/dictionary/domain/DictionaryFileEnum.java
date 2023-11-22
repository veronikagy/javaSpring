package ru.mmtr.dictionary.domain;

public enum DictionaryFileEnum {
    DICTIONARY1(1, new ValidationRule("[a-zA-Z]{4}")),
    DICTIONARY2(2, new ValidationRule("[0-9]{5}"));

    private final ValidationRule dictionaryPattern;

    private final Integer dictionaryNumber;

    public ValidationRule getDictionaryPattern() {
        return dictionaryPattern;
    }

    public Integer getDictionaryNumber() {
        return dictionaryNumber;
    }

    DictionaryFileEnum(Integer dictionaryNumber, ValidationRule dictionaryPattern) {
        this.dictionaryNumber = dictionaryNumber;
        this.dictionaryPattern = dictionaryPattern;
    }

    public static DictionaryFileEnum resolveDictionaryNumber(int dictionary_number) {
        return switch (dictionary_number) {
            case 1 -> DictionaryFileEnum.DICTIONARY1;
            case 2 -> DictionaryFileEnum.DICTIONARY2;
            default -> null;
        };
    }
}
