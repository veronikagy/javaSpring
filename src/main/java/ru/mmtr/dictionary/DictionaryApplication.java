package ru.mmtr.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yaml")
public class DictionaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DictionaryApplication.class, args);
    }
}
