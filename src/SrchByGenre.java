import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SrchByGenre {

    public static String SrchByGenre(String[][] music){

        Scanner scan = new Scanner(System.in);
        boolean validData = false;
        int number=0, number2=0;
        String genre_slcted=" ", song_slcted = " ", inp1;

        // Move Genre to Set so that you get Unique list only.
        HashSet<String> genre_set = new HashSet<String>();
        for (int i = 0; i< music.length; i++){
            genre_set.add(music[i][3]);
        }

        // Hashmap store key value pair, used this so that I can display 1 - genre way..
        HashMap<String, String> genre_map = new HashMap<String, String>();

        //j is needed so that I can store Key as 1, 2 3...which I will use to display in command line below.
        int j = 1;

        for (String x : genre_set){
            genre_map.put(String.valueOf(j), x);
            j = j+1;
        }

        do {

            System.out.println("Welcome to the Spotifoo music Player!");
            System.out.println("");
            System.out.println("Available Genres:");

            for(String i : genre_map.keySet()){

                System.out.println("[" + i + "]" + " " + genre_map.get(i));

            }
            System.out.println("[0] Return to Main Menu");
            System.out.println("Choose an option and press enter: ");

            try {
                inp1 = scan.nextLine();//tries to get data. Goes to catch if invalid data
                number = Integer.parseInt(inp1);
                validData = true;//if gets data successfully, sets boolean to true
                genre_slcted = genre_map.get(String.valueOf(number));
            } catch (NumberFormatException e) {
                //executes when this exception occurs
                ClrScr.ClrScr();
                System.out.println("");
                System.out.println("*************************");
                System.out.println("Input has to be a number. ");
                System.out.println("*************************");

            }
            // Validates the input against the available valid range
            if ((validData == true) && ((number < 0) || (number > genre_map.size()))) {
                ClrScr.ClrScr();
                System.out.println("*************************");
                System.out.println("Not a Valid Input!");
                System.out.println("*************************");
                System.out.println("");
                validData = false;
            }

            if ((validData == true) && (number != 0)){ // if true that means above validation has passed.
                // Time to run another do loop for songs for that Artist.
                // In case User selects 0, then come back with continue to return to parent Do while loop.

                boolean validData2 = false;
                HashMap<String, String> SongsByGenre_map = new HashMap<String, String>();
                int n = 1;
                String s3;

                for(int y = 0; y< music.length; y++){

                    s3 = music[y][3];

                    if (genre_slcted.matches(s3)){

                        SongsByGenre_map.put(String.valueOf(n),music[y][0]);
                        n = n + 1;

                    }

                }

                do{

                    ClrScr.ClrScr();
                    System.out.println("Welcome to the Spotifoo music Player!");
                    System.out.println("");
                    System.out.println("Songs Menu - " + genre_slcted);

                    for(String i : SongsByGenre_map.keySet()){

                        System.out.println("[" + i + "]" + " " + SongsByGenre_map.get(i));

                    }
                    System.out.println("[0] Return to Previous Menu");
                    System.out.println("Choose an option and press enter: ");

                    try {
                        inp1 = scan.nextLine();//tries to get data. Goes to catch if invalid data
                        number2 = Integer.parseInt(inp1);
                        validData2 = true;//if gets data successfully, sets boolean to true
                        song_slcted = SongsByGenre_map.get(String.valueOf(number2));
                    }catch (NumberFormatException e) {
                        //executes when this exception occurs
                        ClrScr.ClrScr();
                        System.out.println("");
                        System.out.println("*************************");
                        System.out.println("Input has to be a number. ");
                        System.out.println("*************************");


                    }
                    if ((validData2 == true) && ((number2 < 0) || (number2 > SongsByGenre_map.size()))) {
                        ClrScr.ClrScr();
                        System.out.println("*************************");
                        System.out.println("Not a Valid Input!");
                        System.out.println("*************************");
                        System.out.println("");
                        validData2 = false;
                    }

                    if((validData2 == true) && (number2 == 0)){
                        ClrScr.ClrScr();
                        validData = false;

                    }



                }while(validData2==false);

            }

        }while(validData==false);//loops until validData is true

        if (number == 0){
            return "Zero";
        }else{
            return song_slcted;
        }

    }

}
