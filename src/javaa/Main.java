package javaa;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Oper oper = null;
        System.out.println("C каким языком вы хотите работать?\n1) С первым языком\n2) Со вторым языком");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        oper = switch (i) {
            case 1 -> new Oper("C:\\Users\\veron\\IdeaProjects\\slovary\\src\\slovary");
            default -> new Oper("C:\\Users\\veron\\IdeaProjects\\slovary\\src\\slovary2");
        };
        //System.out.println("Что вы хотите сделать?\n1)Удалить запись по ключу \n2) Найти запись по ключу \n3) Добавить запись по ключу");

        scanner.close();
        oper.delete("pers");


        /*TODO
        1) ПРОВЕРКА В addInFile НА ОДНАКОВЫЕ КЛЮЧИ
        2) addInFile ЗАПИСЬ С НОВОЙ СТРОКИ
        3) ВЫБОР С КОНСОЛИ
        */

    }
}
