package ru.mmtr.dictionary.Entitles;

public enum DictionaryFileEnum {
    DICTIONARY1(new ValidationRule("[a-zA-Z]{4}")),
    DICTIONARY2(new ValidationRule("[0-9]{5}"));
    private final ValidationRule dictionary_pattern;

    public ValidationRule getDictionary_description() {
        return dictionary_pattern;
    }

    DictionaryFileEnum(ValidationRule dictionary_pattern) {
        this.dictionary_pattern = dictionary_pattern;
    }
}
