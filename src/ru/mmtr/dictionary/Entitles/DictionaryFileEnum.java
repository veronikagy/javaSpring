package ru.mmtr.dictionary.Entitles;

public enum DictionaryFileEnum {
    DICTIONARY1("Letter4"),
    DICTIONARY2("Number5");
    private String dictionary_number;

    public String getDictionary_number() {
        return this.dictionary_number;
    }

    DictionaryFileEnum(String dictionary_number) {
        this.dictionary_number = dictionary_number;
    }
}
