import java.util.Scanner;

public class Menu {
    public static void menu()

    {
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
                "Пожалуйста введите число!!!\n" };
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }

        str = "Введите команду: ";

        Printer.print(str);
        Scanner input = new Scanner(System.in);
        int cmd = input.nextInt();
        if (cmd <= 5 && cmd > 0) {
            System.out.println("Диапозон правильный");
            if (cmd == 1) {
                System.out.println("one");
                exit = false;
            }
            if (cmd == 2) {
                System.out.println("two");
                exit = false;
            }
            if (cmd == 3) {
                System.out.println("Three");
                exit = false;
            }
            if (cmd == 4) {
                System.out.println("four");
                exit = false;
            }
            if (cmd == 5) {
                System.out.println("Exit");
                input.close();
                exit = true;
            }

        }
    }
}