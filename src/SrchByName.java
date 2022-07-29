import java.util.Scanner;

public class SrchByName {

    public static String SrchName(String[][] music){

        Scanner scan = new Scanner(System.in);
        boolean validData = false;
        int number=0;
        String inp1;


        do {
            int i, j = 0;

            System.out.println("Welcome to the Spotifoo music Player!");
            System.out.println("");
            System.out.println("Songs Menu : ");

            for (i = 0; i < music.length; i++) {

                j = i + 1;
                System.out.println("[" + j + "] " + music[i][0]);

            }
            System.out.println("[0] Return to Main Menu");
            System.out.println("Choose an option and press enter: ");
            try {
                inp1 = scan.nextLine();//tries to get data. Goes to catch if invalid data
                number = Integer.parseInt(inp1);
                validData = true;//if gets data successfully, sets boolean to true
            } catch (NumberFormatException e) {
                //executes when this exception occurs
                ClrScr.ClrScr();
                System.out.println("");
                System.out.println("*************************");
                System.out.println("Input has to be a number. ");
                System.out.println("*************************");

            }
            // Validates the input against the available valid range
            if ((validData == true) && ((number < 0) || (number > 20))) {
                ClrScr.ClrScr();
                System.out.println("*************************");
                System.out.println("Not a Valid Input!");
                System.out.println("*************************");
                System.out.println("");
                validData = false;
            }

        }while(validData==false);//loops until validData is true

        if (number == 0){

            return "Zero";
        }else{
            return music[number-1][0];
        }

    }
}
