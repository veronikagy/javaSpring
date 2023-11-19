package ru.mmtr.dictionary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.mmtr.dictionary.Controller.Console;
import ru.mmtr.dictionary.FrameworkAndDrivers.ReaderWriter;
import ru.mmtr.dictionary.Service.OperationDictionary;

@Configuration
@ComponentScan(basePackages = "ru.mmtr.dictionary")
public class DictionaryConfiguration {

}
