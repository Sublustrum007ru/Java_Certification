package Java_Certification;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
            File file = new File(path);
            BufferedWriter bf = null;
            try {
                bf = new BufferedWriter(new FileWriter(file));
                for (Map.Entry<String, ArrayList<String>> entry : myPhoneBook.entrySet()) {
                    bf.write(entry.getKey() + ":" + entry.getValue());
                    bf.newLine();
                }
                bf.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bf.close();
                } catch (Exception e) {
                }
            }

        } else {
            System.out.println("Такое имя уже существует");
            System.out.println("Выберите что вы желаете сделать");
            String[] twoMenu = { "1. Добавить к существуещему",
                    "2. Изменить существующий",
                    "3. Выход",
            };
            for (int i = 0; i < twoMenu.length; i++) {
                System.out.println(twoMenu[i]);
            }
        }

    }

    public static void edit() {
        System.out.println("edit");
    }

    public static void del() {
        System.out.println("Запись успешно удалена");

    }

    public static Map<String, String> printBook() {
        Map<String, String> map = new HashMap<String, String>();
        BufferedReader br = null;

        try {
            String path = "myPhoneBook.txt";

            // create file object
            File file = new File(path);

            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line = null;

            // read file line by line
            while ((line = br.readLine()) != null) {

                // split the line by :
                String[] parts = line.split(":");

                // first part is name, second is number
                String name = parts[0].trim();
                String number = parts[1].trim();

                // put name, number in HashMap if they are
                // not empty
                if (!name.equals("") && !number.equals(""))
                    map.put(name, number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
                ;
            }
        }

        return map;
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

                    Map<String, String> mapFromFile = printBook();

                    // iterate over HashMap entries
                    for (Map.Entry<String, String> entry : mapFromFile.entrySet()) {
                        System.out.println(entry.getKey() + " : "
                                + entry.getValue());
                    }
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
                while (inputWarning.hasNextLine()) {
                    System.out.println(inputWarning.nextLine());
                }
                System.out.println();
            }

        } else {
            System.out.println();
            while (inputWarning.hasNextLine()) {
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