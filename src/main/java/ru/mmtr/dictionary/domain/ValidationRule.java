package ru.mmtr.dictionary.domain;

import lombok.Getter;
import ru.mmtr.dictionary.exceptions.VerificationException;

@Getter
public class ValidationRule {
    private final String pattern;
    public ValidationRule(String pattern) {
        this.pattern = pattern;
    }

    public boolean verification(String key) {
        if (key.matches(pattern)) {
            return true;
        } else {
            throw new VerificationException("Неправильный ключ.");
        }
    }
}
