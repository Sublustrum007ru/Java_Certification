import java.util.Scanner;

public class Menu {
    public static void menu() {
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        // int cmd = 0;
        String str = "";
        String[] m = { "",
                "1. Добавить запись.",
                "2. Изменить запись",
                "3. Удалить запись",
                "4. Вывести всю книгу",
                "5. Выход",
        };
        String[] msg = { "ОШИБКА!!!\n",
                    "Вы ввели не верное число или вовсе не число.\n",
                    "Похалуюйста введите число!!!\n" };
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }
        while (!flag) {
            str = "Введите команду: ";
            Printer.print(str);
            int cmd = input.nextInt();
            if(cmd <= 5 && cmd > 0){
                System.out.println("Диапозон правильный");
                if(cmd == 1){Add.addNew();}
                if(cmd == 2){System.out.println("Two"); menu();}
                if(cmd == 3){System.out.println("Thre"); menu();}
                if(cmd == 4){System.out.println("Four"); menu();}
                if(cmd == 5){
                    flag = true;
                    System.out.println("Exit");
                }
            }else{
                menu();
            }       
        }
        input.close();
    }
}