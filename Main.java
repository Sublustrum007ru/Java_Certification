package Java_Certifiation;

import java.util.Scanner;
public class Main{
    protected static Boolean exit = false;
    public static void main(String[] args){
        String[] msg = {"$-------------------------$\n",
                        "Hello world\n", 
                        "My name is Sublustrum007\n",
                        "$-------------------------$\n",
                        "\n",
                    };
        for(int i = 0; i < msg.length; i++){
            Printer.print(msg[i]);
        }
        while (!Menu.exit) {
            Menu.menu();
        };
    }
}