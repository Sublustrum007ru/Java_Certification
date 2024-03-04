package Java_Certification;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class programm {
    protected static Boolean exit = false;
    static Scanner input = new Scanner(System.in);
    static HashMap<String, ArrayList<String>> myPhoneBook = new HashMap<>();
    final static String path = "myPhoneBook.txt";

    public static void print(String args) {
        System.out.print(args);
    }

    public static void add() {
        System.out.print("Введите Имя и Фамилию, черз пробел: ");
        // String name = input.nextLine();
        String key = input.nextLine();
        System.out.print("Введите номер телефона: ");
        String phoneNum = input.nextLine();
        if (myPhoneBook.containsKey(key) == false) {
            ArrayList<String> value = new ArrayList<>();
            value.add(phoneNum);
            myPhoneBook.put(key, value);
        } else {
            System.out.println("Такое имя уже существует!!!");
            ArrayList<String> value = new ArrayList<>();
            value = myPhoneBook.get(key);
            value.add(phoneNum);
            myPhoneBook.replace(key, value);
        }

    }

    public static void edit() {
        System.out.println("Запись успешно изменена");

    }

    public static void del() {
        System.out.println("Запись успешно удалена");

    }

    public static HashMap<String, ArrayList<String>> printBook() {
        return myPhoneBook;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void menu() throws FileNotFoundException {
        String pathMenu = "menu.txt";
        String pathWarning = "warning.txt";
        File menu = new File(pathMenu);
        File warning = new File(pathWarning);
        Scanner inputMenu = new Scanner(menu);
        Scanner inputWarning = new Scanner(warning);
        while (inputMenu.hasNextLine()) {
            System.out.println(inputMenu.nextLine());
        }
        inputMenu.close();
        String str = "Введите команду: ";
        print(str);
        String temp = input.nextLine();
        if (isNumeric(temp) == true) {
            int cmd = Integer.parseInt(temp);
            if (cmd <= 5 && cmd > 0) {
                if (cmd == 1) {
                    add();
                    System.out.println();
                    exit = false;
                }
                if (cmd == 2) {
                    edit();
                    System.out.println();
                    exit = false;
                }
                if (cmd == 3) {
                    del();
                    System.out.println();
                    exit = false;
                }
                if (cmd == 4) {
                    System.out.println(printBook());
                    System.out.println();
                    exit = false;
                }
                if (cmd == 5) {
                    System.out.println("Exit");
                    input.close();
                    exit = true;
                }

            } else {
                System.out.println();
                while(inputWarning.hasNextLine()){
                    System.out.println(inputWarning.nextLine());
                }
                System.out.println();
            }

        } else {
            System.out.println();
            while(inputWarning.hasNextLine()){
                System.out.println(inputWarning.nextLine());
            }
            System.out.println();
            inputWarning.close();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathMsg = "msg.txt";
        File msg = new File(pathMsg);
        Scanner scanner = new Scanner(msg);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        System.out.println();
        scanner.close();

        while (!programm.exit) {
            programm.menu();
        }
    }
}