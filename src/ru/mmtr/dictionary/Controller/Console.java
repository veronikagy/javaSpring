package ru.mmtr.dictionary.Controller;

import org.springframework.stereotype.Component;
import ru.mmtr.dictionary.Entitles.DictionaryFileEnum;
import ru.mmtr.dictionary.Service.OperationDictionary;
import ru.mmtr.dictionary.Service.Operation;

import java.util.Scanner;

@Component
public class Console implements ConsoleI{

    private static final Operation oper = new OperationDictionary();
    private static DictionaryFileEnum fileNameEnum;

    public void run(){
        try(Scanner scanner = new Scanner(System.in)) {
            String key,value,number_dictionary,number_operation;
            boolean ok = false;
            while (!ok) {
                System.out.println("Выберите, с какимм словарём хотите работать:\n" +
                        "1) Словарь с 4 буквами.\n" +
                        "2) Словарь с 5 цифрами.\n" +
                        "exit, если хотите закончить работу.");
                number_dictionary = scanner.nextLine();
                switch (number_dictionary) {
                    case "1":
                        ok = true;
                        fileNameEnum = DictionaryFileEnum.DICTIONARY1;
                        break;
                    case "2":
                        ok = true;
                        fileNameEnum = DictionaryFileEnum.DICTIONARY2;
                        break;
                    case "exit":
                        return;
                    default:
                        System.out.println("Выберите цифру 1 или 2.");
                }
            }
            ok = false;
            while (!ok) {
                System.out.println("Выберите, что вы хотите сделать:\n" +
                        "1) Найти запись по ключу в словаре.\n" +
                        "2) Удалить запись по ключу в словаре.\n" +
                        "3) Добавить запись в словарь.\n" +
                        "exit, если хотите закончить работу." );
                number_operation = scanner.nextLine();
                switch (number_operation) {
                    case "1":
                        ok = true;
                        System.out.println("Укажите ключ:");
                        key = scanner.next();
                        oper.search(key,fileNameEnum);
                        break;
                    case "2":
                        ok = true;
                        System.out.println("Укажите ключ:");
                        key = scanner.next();
                        oper.delete(key,fileNameEnum);
                        break;
                    case "3":
                        ok = true;
                        System.out.println("Укажите ключ:");
                        key = scanner.next();
                        System.out.println("Укажите значение:");
                        value = scanner.next();
                        oper.addInFile(key, value,fileNameEnum);
                        break;
                    case "exit":
                        return;
                    default:
                        System.out.println("Ввыберите цифру 1, 2 или 3.");
                }
            }
        }
    }
}
