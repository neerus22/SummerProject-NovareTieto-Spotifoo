import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SrchByAlbum {

    public static String SrchByAlbum(String[][] music){

        Scanner scan = new Scanner(System.in);
        boolean validData = false;
        int number=0, number2=0;
        String album_slcted=" ", song_slcted = " ", inp1;

        // Move Album to Set so that you get Unique list only.
        HashSet<String> album_set = new HashSet<String>();
        for (int i = 0; i< music.length; i++){
            album_set.add(music[i][2]);
        }

        // Hashmap store key value pair, used this so that I can display 2 - album way
        HashMap<String, String> album_map = new HashMap<String, String>();

        // j is needed so that I can store Key as 1, 2 3...which I will use to display in command line

        int j = 1;

        for (String x : album_set){
            album_map.put(String.valueOf(j), x);
            j = j+1;
        }

        do {

            System.out.println("Welcome to the Spotifoo music Player!");
            System.out.println("");
            System.out.println("Available Albums:");

            for(String i : album_map.keySet()){

                System.out.println("[" + i + "]" + " " + album_map.get(i));

            }
            System.out.println("[0] Return to Main Menu");
            System.out.println("Choose an option and press enter: ");

            try {
                inp1 = scan.nextLine();//tries to get data. Goes to catch if invalid data
                number = Integer.parseInt(inp1);
                validData = true;//if gets data successfully, sets boolean to true
                album_slcted = album_map.get(String.valueOf(number));
            } catch (NumberFormatException e) {
                //executes when this exception occurs
                ClrScr.ClrScr();
                System.out.println("");
                System.out.println("*************************");
                System.out.println("Input has to be a number. ");
                System.out.println("*************************");
            }

            // Validates the input against the available valid range
            if ((validData == true) && ((number < 0) || (number > album_map.size()))) {
                ClrScr.ClrScr();
                System.out.println("*************************");
                System.out.println("Not a Valid Input!");
                System.out.println("*************************");
                System.out.println("");
                validData = false;
            }

            if ((validData == true) && (number != 0)){ // if true that means above validation has passed.
                // Time to run another do loop for songs for that Album
                // In case User selects 0, then come back with continue to return to parent 'Do while' loop.

                boolean validData2 = false;
                HashMap<String, String> SongsByAlbum_map = new HashMap<String, String>();
                int n = 1;
                String s3;


                for(int y = 0; y< music.length; y++){

                    s3 = music[y][2];
                    if (album_slcted.matches(s3)){

                        SongsByAlbum_map.put(String.valueOf(n),music[y][0]);
                        n = n + 1;
                    }
                }

                do{
                    ClrScr.ClrScr();
                    System.out.println("Welcome to the Spotifoo music Player!");
                    System.out.println("");
                    System.out.println("Songs Menu - " + album_slcted);

                    for(String i : SongsByAlbum_map.keySet()){

                        System.out.println("[" + i + "]" + " " + SongsByAlbum_map.get(i));

                    }
                    System.out.println("[0] Return to Previous Menu");
                    System.out.println("Choose an option and press enter: ");


                    try {
                        inp1 = scan.nextLine();//tries to get data. Goes to catch if invalid data
                        number2 = Integer.parseInt(inp1);
                        validData2 = true;//if gets data successfully, sets boolean to true
                        song_slcted = SongsByAlbum_map.get(String.valueOf(number2));
                    }catch (NumberFormatException e) {
                        //executes when this exception occurs
                        ClrScr.ClrScr();
                        System.out.println("");
                        System.out.println("*************************");
                        System.out.println("Input has to be a number. ");
                        System.out.println("*************************");
                    }

                    if ((validData2 == true) && ((number2 < 0) || (number2 > SongsByAlbum_map.size()))) {
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
