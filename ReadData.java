import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {

    public static String[][] Readfile(String DF) {

        String [][] music = new String[20][6];

        try{
            File myObj = new File(DF);
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            int j;
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().trim().split(",");

                for (j=0; j<6; j++){
                    music[i][j] = data[j];

                }

                i = i + 1;

            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading data.txt file.");

        }

        return music;
    }
}
