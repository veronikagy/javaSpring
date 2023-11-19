package ru.mmtr.dictionary.java;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.mmtr.dictionary.Controller.Console;
import ru.mmtr.dictionary.Controller.ConsoleI;
import ru.mmtr.dictionary.FrameworkAndDrivers.ReaderWriter;
import ru.mmtr.dictionary.config.DictionaryConfiguration;

@Component
public class Main {
    private static ConsoleI console;
    @Autowired
    public Main(ConsoleI console) {
        this.console = console;
    }


    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(DictionaryConfiguration.class);

        console.run();
//        SpringApplication.run(ApplicationCommand.class, args);
    }
}
