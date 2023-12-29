package ru.mmtr.dictionary.exceptions;

public class UnknownDictionaryTypeException extends RuntimeException {
    public UnknownDictionaryTypeException(String message) {
        super(message);
    }
}
