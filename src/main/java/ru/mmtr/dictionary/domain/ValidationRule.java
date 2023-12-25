package ru.mmtr.dictionary.domain;

import lombok.Getter;

@Getter
public class ValidationRule {
    private final String pattern;

    public ValidationRule(String pattern) {
        this.pattern = pattern;
    }

    public boolean verification(String key) {
        return key.matches(pattern);
    }
}
