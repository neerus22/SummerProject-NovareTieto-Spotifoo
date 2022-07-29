import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SrchByText {

    public static String SrchByText(String[][] music){

        Scanner scan = new Scanner(System.in);
        boolean validData = false;
        int number=0, n = 1;
        String text_slcted=" ", song_slcted = " ", tmp_strng0, inp1, tmp_strng1, tmp_strng2, tmp_strng3;


        System.out.println("Welcome to the Spotifoo music Player!");
        System.out.println("");
        System.out.println("To find a song, enter a search text:");
        text_slcted = scan.nextLine();

        HashMap<String, String> SongsByText_map = new HashMap<String, String>();

        for(int i=0 ; i<music.length; i++){

            tmp_strng0 = music[i][0];
            tmp_strng1 = music[i][1];
            tmp_strng2 = music[i][2];
            tmp_strng3 = music[i][3];
            if (tmp_strng0.toLowerCase().contains(text_slcted.toLowerCase()) ||
                    tmp_strng1.toLowerCase().contains(text_slcted.toLowerCase()) ||
                    tmp_strng2.toLowerCase().contains(text_slcted.toLowerCase()) ||
                    tmp_strng3.toLowerCase().contains(text_slcted.toLowerCase())){

                SongsByText_map.put(String.valueOf(n),music[i][0]);
                n = n + 1;

            }

        }

        do{

            ClrScr.ClrScr();
            System.out.println("Welcome to the Spotifoo music Player!");
            System.out.println("");

            if(SongsByText_map.size() == 0){

                System.out.println("No Song Found for searched text - " + text_slcted);
                System.out.println("Press 0 to return to Main Menu and try again!!!");

            }else{
                System.out.println("Songs Menu for searched text- " + text_slcted);
                for(String i : SongsByText_map.keySet()){

                    System.out.println("[" + i + "]" + " " + SongsByText_map.get(i));

                }
                System.out.println("[0] Return to Main Menu");
                System.out.println("Choose an option and press enter: ");
            }

            try {
                inp1 = scan.nextLine();//tries to get data. Goes to catch if invalid data
                number = Integer.parseInt(inp1);
                validData = true;//if gets data successfully, sets boolean to true
                song_slcted = SongsByText_map.get(String.valueOf(number));
            }catch (NumberFormatException e) {
                //executes when this exception occurs
                ClrScr.ClrScr();
                System.out.println("");
                System.out.println("*************************");
                System.out.println("Input has to be a number. ");
                System.out.println("*************************");


            }

            if ((validData == true) && ((number < 0) || (number > SongsByText_map.size()))) {
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
            return song_slcted;
        }

    }
}
