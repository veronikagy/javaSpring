package ru.mmtr.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DictionaryApplication {
    public static void main(String[] args) {
         SpringApplication.run(DictionaryApplication.class, args);
    }
}

