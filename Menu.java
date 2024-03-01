import java.util.Scanner;

public class Menu {
    public static void menu() {
        boolean flag = true;
        String[] m = { "1. Добавить запись.",
                "2. Изменить запись",
                "3. Удалить запись",
                "4. Вывести всю книгу",
                "5. Выход",
        };
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }
        System.out.print("Введите команду: ");
        Scanner input = new Scanner(System.in);
        int cmd = input.nextInt();
        
        while (flag){
            switch (cmd) {
                case 1:
                    System.out.println("Add");
                    menu();
                    break;
                case 2:
                    System.out.println("Edit");
                    menu();
                    break;
                case 3:
                    System.out.println("Delet");
                    menu();
                    break;
                case 4:
                    System.out.println("print book");
                    menu();
                    break;
                case 5:
                    System.out.println("Exit");
                    flag = false;
                    break;
                default:
                    String str = "Bad command!!!";
                    Printer.print(str);
                    menu();
                    break;
            }
       
        }
        input.close();
    }
}