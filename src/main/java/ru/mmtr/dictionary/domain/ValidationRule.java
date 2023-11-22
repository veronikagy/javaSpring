package ru.mmtr.dictionary.domain;

import ru.mmtr.dictionary.exceptions.VerificationException;

public class ValidationRule {
    private final String pattern;

    public String getPattern() {
        return pattern;
    }

    public ValidationRule(String pattern) {
        this.pattern = pattern;
    }

    public boolean verification(String key) {
        if (key.matches(pattern)) {
            return true;
        } else {
            throw new VerificationException("Wrong key.");
        }
    }
}
