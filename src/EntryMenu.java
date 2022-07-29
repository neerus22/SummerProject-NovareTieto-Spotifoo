import java.util.InputMismatchException;
import java.util.Scanner;

public class EntryMenu {
    public static int mainscreen() {

        Scanner scan = new Scanner(System.in);
        boolean validData = false;
        String inp1;
        int number=0;

        do{
            System.out.println("Welcome to the Spotifoo music Player!");
            System.out.println("");
            System.out.println("Main menu options:");
            System.out.println("[1] Songs");
            System.out.println("[2] Artists");
            System.out.println("[3] Albums");
            System.out.println("[4] Genres");
            System.out.println("[5] Search");
            System.out.println("[0] Exit");
            System.out.println("Choose an option and press enter: ");

            try{
                inp1 = scan.nextLine();//tries to get data. Goes to catch if invalid data
                number = Integer.parseInt(inp1);
                validData = true;//if gets data successfully, sets boolean to true
            }catch(NumberFormatException e){
                //executes when this exception occurs
                ClrScr.ClrScr();
                System.out.println("");
                System.out.println("*************************");
                System.out.println("Input has to be a number. ");
                System.out.println("*************************");

            }
            // Validates the input against the available valid range
            if ( (validData == true) && ((number < 0) || (number > 5))){
                ClrScr.ClrScr();
                System.out.println("*************************");
                System.out.println("Not a Valid Input!");
                System.out.println("*************************");
                System.out.println("");
                validData = false;

            }
        }while(validData==false);//loops until validData is true

        return number;



    }

}
