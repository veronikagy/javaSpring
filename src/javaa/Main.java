package javaa;
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
        }


        scanner.close();


    }
}
