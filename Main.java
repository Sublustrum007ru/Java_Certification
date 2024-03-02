public class Main{

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
        
        Menu.menu();

    }
}