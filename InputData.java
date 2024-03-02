import java.util.Scanner;
import java.util.ArrayList;

public class InputData{
    public static Integer inputInt(){
        Integer result = 1000;
        return result;
    }
    public static String inputStr(){
        Scanner input = new Scanner(System.in);
        String result = input.nextLine();
        input.close();
        return result;
        
    }
}