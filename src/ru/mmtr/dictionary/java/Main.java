package ru.mmtr.dictionary.java;
import ru.mmtr.dictionary.Controller.Console;
import ru.mmtr.dictionary.Controller.ConsoleI;


public class Main {
    private static final ConsoleI console = new Console();
    public static void main(String[] args) {
        console.run();
    }
}
