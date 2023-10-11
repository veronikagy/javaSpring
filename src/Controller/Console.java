package Controller;

import Service.OperaziiSlovary1;
import Service.Operazii;
import Service.OperaziiSlovary2;

import java.util.Scanner;

public class Console implements ConsoleI{
    private static Operazii oper = new OperaziiSlovary1();
    private static Operazii oper2 = new OperaziiSlovary2();
    private String key;
    private String value;
    public void run(){
        System.out.println("Выберите, что вы хотите сделать:\n" +
                "1) Найти запись по ключу в первом словаре.\n" +
                "2) Найти запись по ключу в первом словаре.\n" +
                "3) Удалить запись по ключу в первом словаре.\n" +
                "4) Удалить запись по ключу в первом словаре.\n" +
                "5) Добавить запись в первый словарь.\n" +
                "6) Добавить запись во второй словарь.");

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i){
            case 1:
                System.out.println("Введите ключ");
                key = scanner.next();
                oper.poisk(key);
                break;
            case 2:
                System.out.println("Введите ключ");
                key = scanner.next();
                oper2.poisk(key);
                break;
            case 3:
                System.out.println("Введите ключ");
                key = scanner.next();
                oper.delete(key);
                break;
            case 4:
                System.out.println("Введите ключ");
                key = scanner.next();
                oper2.delete(key);
                break;
            case 5:
                System.out.println("Введите ключ и значение");
                key = scanner.next();
                value = scanner.next();
                oper.addInFile(key,value);
                break;
            case 6:
                System.out.println("Введите ключ и значение");
                key = scanner.next();
                value = scanner.next();
                oper2.addInFile(key,value);
                break;
            default:
                System.out.println("no");
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
