import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

     public static void main(String[] args) {
         String DF = "..\\..\\..\\assets\\data.txt";
         String AP = "..\\..\\..\\assets\\Songs\\";
         String IP = "..\\..\\..\\assets\\Albums\\";


         // Read data file and build 2d Array!
         String[][] music = ReadData.Readfile(DF);

         boolean musicfound = false;
         String MusicReturned ="";
         int inp;

         do{

             // Function to show user the main menu !!!
             inp = EntryMenu.mainscreen();

             ClrScr.ClrScr();

             switch(inp){
                 case 1:
                     MusicReturned = SrchByName.SrchName(music);
                     if (MusicReturned == "Zero"){
                         ClrScr.ClrScr();
                         continue;
                     }else{
                         musicfound = true;
                         break;
                     }
                 case 2:
                     MusicReturned = SrchByArtist.SrchByArtist(music);
                     if (MusicReturned == "Zero"){
                         ClrScr.ClrScr();
                         continue;
                     }else{
                         musicfound = true;
                         break;
                     }
                 case 3:
                     MusicReturned = SrchByAlbum.SrchByAlbum(music);
                     if (MusicReturned == "Zero"){
                         ClrScr.ClrScr();
                         continue;
                     }else{
                         musicfound = true;
                         break;
                     }
                 case 4:
                     MusicReturned = SrchByGenre.SrchByGenre(music);
                     if (MusicReturned == "Zero"){
                         ClrScr.ClrScr();
                         continue;
                     }else{
                         musicfound = true;
                         break;
                     }
                 case 5:
                     MusicReturned = SrchByText.SrchByText(music);
                     if (MusicReturned == "Zero"){
                         ClrScr.ClrScr();
                         continue;
                     }else{
                         musicfound = true;
                         break;
                     }
                 case 0:
                     musicfound = true;
                     break;

                 default:
                     throw new IllegalStateException("Unexpected value: " + inp);

                 }

         }while(musicfound==false);

         if(inp != 0){
             System.out.println("Song selected : " + MusicReturned);
             PlayMusic.PlayMusic(MusicReturned, music, AP, IP);

         }

     }
}