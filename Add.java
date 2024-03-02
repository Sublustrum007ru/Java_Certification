import java.util.Scanner;
import java.util.ArrayList;

public class Add {
    public static void addNew() {
        String str;
        str = "Введите Имя и Фамилию, через пробел: ";
        Printer.print(str);
        Scanner input = new Scanner(System.in);
        ArrayList<String> key = new ArrayList<>();
        key.add(input.nextLine());
        input.close();
        System.out.println(key);
        System.out.println("Заись успехно добавлена.");
        Menu.menu();
    }
}