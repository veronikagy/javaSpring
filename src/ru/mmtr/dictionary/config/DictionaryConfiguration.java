package ru.mmtr.dictionary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.mmtr.dictionary.Controller.Console;

@Configuration
@ComponentScan(basePackages = "ru.mmtr.dictionary")
public class DictionaryConfiguration {
    @Bean
    public Console console(){
        return new Console();
    }
}
