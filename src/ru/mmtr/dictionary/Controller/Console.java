package ru.mmtr.dictionary.Controller;

import ru.mmtr.dictionary.Entitles.DictionaryFileEnum;
import ru.mmtr.dictionary.Service.OperationDictionary1;
import ru.mmtr.dictionary.Service.Operation;
import ru.mmtr.dictionary.Service.OperationDictionary2;

import java.util.Scanner;

public class Console implements ConsoleI{
    private static DictionaryFileEnum fileNameEnum;
    private static Operation oper;
    private String key;
    private String value;

    public static DictionaryFileEnum getFileNameEnum() {
        return fileNameEnum;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean ok = false;
        String number_dictionary;
        String number_operation;
        while (!ok){
            System.out.println("Выберите, с какимм словарём хотите работать:\n" +
                    "1) Словарь с 4 буквами.\n" +
                    "2) Словарь с 5 цифрами." );
            number_dictionary = scanner.nextLine();
            switch (number_dictionary){
                case "1":
                    ok = true;
                    fileNameEnum = DictionaryFileEnum.DICTIONARY1;
                    oper = new OperationDictionary1(fileNameEnum);
                    break;
                case "2":
                    ok = true;
                    fileNameEnum = DictionaryFileEnum.DICTIONARY2;
                    oper = new OperationDictionary2(fileNameEnum);
                    break;
                default:
                    System.out.println("Ввыберите цифру 1 или 2.");
            }
        }
        ok = false;
        while (!ok) {
            System.out.println("Выберите, что вы хотите сделать:\n" +
                    "1) Найти запись по ключу в словаре.\n" +
                    "2) Удалить запись по ключу в словаре.\n" +
                    "3) Добавить запись в словарь.");
            number_operation = scanner.nextLine();
            switch (number_operation){
                case "1":
                    ok = true;
                    System.out.println("Укажите ключ:");
                    key = scanner.next();
                    oper.search(key);
                    break;
                case "2":
                    ok = true;
                    System.out.println("Укажите ключ:");
                    key = scanner.next();
                    oper.delete(key);
                    break;
                case "3":
                    ok = true;
                    System.out.println("Укажите ключ:");
                    key = scanner.next();
                    System.out.println("Укажите значение:");
                    value = scanner.next();
                    oper.addInFile(key,value);
                    break;
                default:
                    System.out.println("Ввыберите цифру 1, 2 или 3.");
            }
        }


        /*oper = switch (i) {
            case 1 -> new OperaziiClass();
            default -> new OperaziiClass();
        };
        System.out.println("Что вы хотите сделать?\n1)Удалить запись по ключу \n2) Найти запись по ключу \n3) Добавить запись по ключу");
        String key;
        String value;
        int i2 = scanner.nextInt();
        if (i2 == 1){
            System.out.println("Укажите ключ:");
            key = scanner.next();
            oper.delete(key);
        } else if (i2==2) {
            System.out.println("Укажите ключ:");
            key = scanner.next();
            oper.poisk(key);
        }else if (i2==3){
            String s = i==1 ? "Ключ должен состоять из 4 латинских букв." : "Ключ должен состоять из 5 цифр.";
            System.out.println(s);
            System.out.println("Укажите ключ:");
            key = scanner.next();
            System.out.println("Укажите значение:");
            value = scanner.next();
            oper.addInFile(key,value);
        }*/
        scanner.close();
    }
}
