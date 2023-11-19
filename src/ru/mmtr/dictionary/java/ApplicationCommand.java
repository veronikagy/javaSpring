package ru.mmtr.dictionary.java;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ApplicationCommand {


    @ShellMethod(value = "adding 2 numbers")
    public int add(int a, int b) {
        return a + b;
    }

    @ShellMethod(value = "Hello World", key="key")
    public String hello(@ShellOption(defaultValue = " Nika") String arg) {
        return "Hello" + arg;
    }

}
