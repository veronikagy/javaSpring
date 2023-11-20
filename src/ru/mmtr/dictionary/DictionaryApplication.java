package ru.mmtr.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mmtr.dictionary.Controller.ConsoleI;

@SpringBootApplication
public class DictionaryApplication {


    public static void main(String[] args) {

        SpringApplication.run(DictionaryApplication.class, args);
    }
}
