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
            System.out.println("Такое имя уже существует!!!");
            String[] miniMenu = { "1. Добавить к существующей",
                    "2. Изменить существующую",
                    "3. Выход"
            };
            for (int i = 0; i < miniMenu.length; i++) {
                System.out.println(miniMenu[i]);

            }
            System.out.print("Введите команду: ");
            Scanner miniInput = new Scanner(System.in);
            String miniStr = miniInput.nextLine();
            if (isNumeric(miniStr) == true) {
                int miniCmd = Integer.parseInt(miniStr);
                if (miniCmd <= 3 && miniCmd > 0) {
                    if (miniCmd == 1) {
                        ArrayList<String> value = new ArrayList<>();
                        value = myPhoneBook.get(key);
                        value.add(phoneNum);
                        myPhoneBook.replace(key, value);
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
                        System.out.println();
                        System.out.println("Новый номер телефона успешно добавлен");
                    }
                    if (miniCmd == 2) {
                        ArrayList<String> value = new ArrayList<>();
                        value.add(phoneNum);
                        System.out.println();
                        myPhoneBook.replace(key, value);
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
                        System.out.println();
                        System.out.println("Запись успешно изменена");

                    }
                    if (miniCmd == 3) {
                        System.out.println("three");
                    }
                }
            }
        }

    }

    public static void edit() {
        System.out.print("Введите Имя и Фамилию, черз пробел: ");
        String key = input.nextLine();
        System.out.print("Введите номер телефона: ");
        String phoneNum = input.nextLine();
        ArrayList<String> value = new ArrayList<>();
        value.add(phoneNum);
        myPhoneBook.replace(key, value);
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

        System.out.println();
        System.out.println("Запись успешно изменена");
    }

    public static void del() {
        System.out.print("Введите Имя и Фамилию, черз пробел: ");
        String key = input.nextLine();
        if(myPhoneBook.containsKey(key) == true){
            myPhoneBook.remove(key);
        }
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

        BufferedReader br = null;
        try {
            String path = "myPhoneBook.txt";
            File file = new File(path);
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                for (int i = 0; i < parts.length; i++) {
                    if (i % 2 == 0) {
                        String key = parts[0].trim();
                        ArrayList<String> value = new ArrayList<>();
                        parts[1] = parts[1].replace("[", "").replace("]", "");
                        value.add(parts[1].trim());
                        myPhoneBook.put(key, value);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
                ;
            }
        }

        while (!programm.exit) {
            programm.menu();
        }
    }
}