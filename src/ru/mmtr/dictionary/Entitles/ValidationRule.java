package ru.mmtr.dictionary.Entitles;

import java.sql.SQLOutput;

public class ValidationRule {
    private final String pattern;

    public String getPattern() {
        return pattern;
    }

    public ValidationRule(String pattern) {
        this.pattern = pattern;
    }
    public boolean verification(String key){
        if(key.matches(pattern)){
            return true;
        }
        else {
            System.out.println("Неправильный ключ.");
            return false;
        }
    }
}
