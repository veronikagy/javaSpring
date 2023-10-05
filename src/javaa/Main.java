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
        scanner.close();
        oper.delete("12344");


    }
}
