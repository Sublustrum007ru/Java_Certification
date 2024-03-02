package Java_Certification;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class programm {
    protected static Boolean exit = false;
    static Scanner input = new Scanner(System.in);
    // static ArrayList<String> key = new ArrayList<>();
    // static ArrayList<String> value = new ArrayList<>();
    static HashMap<ArrayList<String>, ArrayList<String>> myPhoneBook = new HashMap<>();
    final static String path = "myPhoneBook.txt";

    public static void print(String args) {
        System.out.print(args);
    }

    public static HashMap<ArrayList<String>, ArrayList<String>> testWriter() {
        File file = new File(path);

        BufferedWriter bf = null;
        ;

        try {

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            // iterate map entries
            for (Map.Entry<ArrayList<String>, ArrayList<String>> entry : myPhoneBook.entrySet()) {

                // put key and value separated by a colon
                bf.write(entry.getKey() + " - " + entry.getValue());

                // new line
                bf.newLine();
            }

            bf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                // always close the writer
                bf.close();
            } catch (Exception e) {
            }
        }
        return myPhoneBook;
    }

    public static void add() {
        ArrayList<String> key = new ArrayList<>();
        System.out.println("Введите Имя и Фамилию, черз пробел");
        String name = input.nextLine();
        key.add(name);
        System.out.println("Введите номер(а) телефона, через пробел");
        String phoneNum = input.nextLine();
        if (myPhoneBook.containsKey(name) == false) {
            ArrayList<String> value = new ArrayList<>();
            value.add(phoneNum);
            myPhoneBook.put(key, value);
            File file = new File(path);
            BufferedWriter bf = null;
            try {
                bf = new BufferedWriter(new FileWriter(file));
                for (Map.Entry<ArrayList<String>, ArrayList<String>> entry : myPhoneBook.entrySet()) {
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
        }else{
            ArrayList<String> value = new ArrayList<>();
            value = myPhoneBook.get(name);
            myPhoneBook.replace(key, value);
            File file = new File(path);
            BufferedWriter bf = null;
            try {
                bf = new BufferedWriter(new FileWriter(file));
                for (Map.Entry<ArrayList<String>, ArrayList<String>> entry : myPhoneBook.entrySet()) {
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
        }

    }

    public static void edit() {
        System.out.println("Запись успешно изменена");

    }

    public static void del() {
        System.out.println("Запись успешно удалена");

    }

    public static HashMap<ArrayList<String>, ArrayList<String>> printBook() {
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

    public static void menu() {
        String[] m = { "",
                "1. Добавить запись.",
                "2. Изменить запись",
                "3. Удалить запись",
                "4. Вывести всю книгу",
                "5. Выход",
        };
        String[] msg = { "\n",
                "***********************************************\n",
                "*                  ОШИБКА!!!                  *\n",
                "* Вы ввели не верное число или вовсе не число.*\n",
                "*          Пожалуйста введите число!!!        *\n",
                "***********************************************",
        };
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }

        String str = "Введите команду: ";
        print(str);
        // Scanner input = new Scanner(System.in);
        String temp = input.nextLine();
        if (isNumeric(temp) == true) {
            int cmd = Integer.parseInt(temp);
            if (cmd <= 5 && cmd > 0) {
                if (cmd == 1) {
                    add();
                    exit = false;
                }
                if (cmd == 2) {
                    edit();
                    exit = false;
                }
                if (cmd == 3) {
                    del();
                    exit = false;
                }
                if (cmd == 4) {
                    printBook();
                    exit = false;
                }
                if (cmd == 5) {
                    System.out.println("Exit");
                    input.close();
                    exit = true;
                }

            } else {
                for (int i = 0; i < msg.length; i++) {
                    print(msg[i]);
                }
            }

        } else {
            for (int i = 0; i < msg.length; i++) {
                System.out.print(msg[i]);

            }
        }
    }

    public static void main(String[] args) {
        String[] str = { "\n",
                "$--------------------------$\n",
                "$ Hello world!!!           $\n",
                "$ My name is Sublustrum007 $\n",
                "$ And this my project      $\n",
                "$ Phone Book               $\n",
                "$--------------------------$\n",
                "\n",
        };
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }

        while (!programm.exit) {
            programm.menu();
        }
    }
}