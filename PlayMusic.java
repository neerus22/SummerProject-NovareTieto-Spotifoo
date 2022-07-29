import java.awt.*;
import java.io.File;

public class PlayMusic {

    public static void PlayMusic(String MusicReturned, String[][] music, String AP, String IP){

        String musicname_with_dash;
        String music_to_play;
        String tmp_strng;
        String image_name = "", image_to_load, save_original_music_name = "";
        boolean load_image = true;

        save_original_music_name = MusicReturned;
        if (MusicReturned.contains("'")){
            System.out.println("Music contains special char");
            MusicReturned = MusicReturned.replaceAll("'", "");

        }

        // Set the music name as per the mp3 name in the folder
        musicname_with_dash = MusicReturned.replace(" ", "-");
        music_to_play = AP + musicname_with_dash + ".mp3";

        // Run MP3 file For Windows!!!!!
        if (Desktop.isDesktopSupported()) {
            try{
                Desktop.getDesktop().open(new File(music_to_play));

            }catch (Exception e1) {
                load_image = false;
                System.out.println("Some issue with Playing audio file, Audio file could not be loaded" );
            }
        }else{ // For Mac!!!!!
            System.out.println("Desktop function is not supported to play music in Mac!!!");
            Runtime runtime = Runtime.getRuntime();
            try{
                Process process = runtime.exec(music_to_play);
            }catch (Exception e){
                System.out.println("Some issue with Playing audio file, Audio file could not be loaded" );
            }
        }

        MusicReturned = save_original_music_name;
        // Get the Image name from the Music array!
        for(int i=0; i<music.length; i++){
            tmp_strng = music[i][0];

            if(tmp_strng.matches(MusicReturned)){
                image_name = music[i][5];
                break;
            }

        }

        if(load_image){

            // Set the Image file name as per the image in folder!
            image_to_load = IP + image_name;

            if(image_name.matches("no file")){
                image_to_load = IP + "no-picture" + ".png";
            }

            // Open Image for Windows!!!!!
            if (Desktop.isDesktopSupported()) {
                try{
                    Desktop.getDesktop().open(new File(image_to_load));
                }catch (Exception e1) {
                    System.out.println("Some issue with Image file, Image file could not be loaded" );
                }
            }else{ // For Mac!!!!!
                System.out.println("Desktop function is not supported to play music in Apple!!!");
                Runtime runtime = Runtime.getRuntime();
                try{
                    Process process = runtime.exec(image_to_load);
                }catch (Exception e){
                    System.out.println("Some issue with Image file, Image file could not be loaded" );
                }
            }

        }

    }
}
