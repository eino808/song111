// Import the Arraylist
import java.util.ArrayList;

// Import the Scanner and InputMismatchException
import java.util.*;

// Import the Date class
import java.util.Date;

// Import the file class
import java.io.File;

// Import the filewriter class to create filewriter objects
import java.io.FileWriter;

// Import the IOException
import java.io.IOException;

/**
 * This program has at least 5 song objects with valid data and uses three
 * custom methods that work within each other. There are also custom exceptions
 * that catch the user from entering anything out of bounds.
 *
 * @author     Inofinada, Elijah
 * @assignment ICS 111 Assignment 16
 * @date       4/30/22
 * @bugs       No Bugs.
 */

public class InofinadaElijah16 {
    public static void main(String[] args) throws Exception{

        Scanner input = new Scanner(System.in);

        /*
         * setting the variable/arraylist so that it exists in the main
         * method which then I could use it in the custom methods
         */
        boolean fileOverwrite = true;
        ArrayList<Song> myPlaylist;
        String msg = "";

        // program begins here
        System.out.println("Lets listen to some tunes !!");

        /*
         * calling on the method
         * setting myPlaylist = to editplaylist so that it works as a parameter
         */
        try {
            myPlaylist = editPlaylist(createPlaylist());
            System.out.println("Did you want to save the playlist so you can listen to it later?");
            msg = input.nextLine();
            if (msg.equalsIgnoreCase("yes")) {
                savePlaylist(myPlaylist, fileOverwrite);
            }
            else if (msg.equalsIgnoreCase("no")) {
                System.out.println("Thanks for using my program :D");
            }
            else {
                System.out.println("I dont quite understand..");
                System.out.println("Please type in yes or no!!");
            }
        }
        catch (SongException se){
            System.out.println(se.getMessage());
        }

    }

    /*
     * An arraylist for songs
     *
     * @return      output       the playlist
     */
    public static ArrayList<Song> createPlaylist() throws Exception {
        System.out.println("\t\t\t** Boba **");
        ArrayList<Song> myPlaylist = new ArrayList<>();
        myPlaylist.add(new Song("SUNSET BOULEVARD", "HOHYUN", 3, 10));
        myPlaylist.add(new Song("KISS ME", "DPR LIVE", 3, 32));
        myPlaylist.add(new Song("Peanut Butter & Tears", "DPR IAN", 3, 44));
        myPlaylist.add(new Song("airplane thoughts", "dhruv", 3, 30));
        myPlaylist.add(new Song("War With Heaven", "Keshi", 3, 12));
        System.out.println(myPlaylist);
        return myPlaylist;
    }

    /*
     * edits the playlist
     *
     * @param     msg      user input
     *
     * @return      output       the playlist
     */
    public static ArrayList<Song> editPlaylist(ArrayList<Song> myPlaylist) throws Exception {

        // Import the scanner object
        Scanner input = new Scanner(System.in);

        // Creating the variables
        String msg = "";
        String title = "";
        String artist = "";
        int min = 0;
        int sec = 0;
        int num = 0;
        int spot = 0;

        /*
         * Method starts here
         * User inputs yes or no
         */
        System.out.println("Do you like it? Should I make any changes?");
        msg = input.nextLine();

        // if yes everything runs from this line to line 149 will run
        if (msg.equalsIgnoreCase("yes")) {
            System.out.println("Should I add, or remove a song... or nevermind?");
            msg = input.nextLine();

            /** If the user DOES NOT input finished everything will run fine
             * The program will keep running until the user inputs finished
             * It allows the user to add and remove an infinite amount of times
             */
            while (!msg.equalsIgnoreCase("finished")) {

                // If the user inputs add this will run
                if (msg.equalsIgnoreCase("add")) {
                    try {
                        System.out.println("For sure! Add in the song information down below :D");
                        System.out.print("Title: ");
                        title = input.nextLine();
                        System.out.print("Artist: ");
                        artist = input.nextLine();
                        System.out.print("Minutes: ");
                        min = input.nextInt();
                        System.out.print("Seconds: ");
                        sec = input.nextInt();
                        System.out.println("What # song should this be in the playlist?");
                        spot = input.nextInt();
                        Song Song1 = new Song(title, artist, min, sec);
                        myPlaylist.add(spot, Song1);
                        System.out.println("Now adding " + Song1 + "as number " + spot + " to the playlist...");
                        System.out.println("\nHeres the new playlist!!");
                        System.out.println(myPlaylist);
                        msg = input.nextLine();
                        System.out.println("Did you want to add or remove a song?");
                        System.out.println("You can also type 'finished' if youre done editing!");
                        msg = input.nextLine();
                    }
                    catch (SongException se) {
                        System.out.println(se.getMessage());
                    }
                }

                // If the user inputs remove this will run
                else if (msg.equalsIgnoreCase("remove")) {
                    System.out.println("For sure! What song did you want to remove?");
                    System.out.println(myPlaylist);
                    num = input.nextInt();
                    input.nextLine();
                    System.out.println("Now removing " + myPlaylist.get(num) + " to the playlist...");
                    myPlaylist.remove(num);
                    System.out.println("\nHeres the new playlist!!");
                    System.out.println(myPlaylist);
                    System.out.println("Did you want to add or remove a song?");
                    System.out.println("You can also type 'finished' if youre done editing!");
                    msg = input.nextLine();
                }

                // If the user inputs nevermind the program will run
                else if (msg.equalsIgnoreCase("nevermind")) {
                    System.out.println("Great, I hope you liked it!!");
                    break;
                }
                // If the user doesnt type add, remove, or finished, the program will not continue
                else {
                    System.out.println("Please say add, remove, or finished!!!");
                    msg = input.nextLine();
                }
            }

            // When the user types finished, the playlist will print out for them to look at
            System.out.println("Heres how the playlist looks so far :D!!");
            System.out.println(myPlaylist);
        }

        // If user inputs no, the program ends
        else if (msg.equalsIgnoreCase("no")) {
            System.out.println("Great, I hope you liked it!!");
        }
        return myPlaylist;
    }

    /*
     * Saves the playlist to the users device in a separate .txt file
     *
     * @param        msg          user input
     *
     * @return      none
     * @exception   IOException
     */
    public static void savePlaylist(ArrayList<Song> myPlaylist, boolean fileOverwrite) {

        // Import the scanner object
        Scanner input = new Scanner(System.in);

        // Import the Date object
        Date date1 = new Date();

        // Creating the variables
        String msg = "";

        // Begins here
        System.out.println("You can save it to a file, type yes or no...");
        msg = input.nextLine();

        // Checks to make sure the user enters a numerical value
        try {

            // If the user inputs yes the program will continue to run till the user
            // finishes the set of questions
            if (msg.equalsIgnoreCase("yes")) {
                System.out.println("The playlist will now be saved to playlist.txt");
                System.out.println("Would you like to append or overwrite?");
                msg = input.nextLine();
                if (msg.equalsIgnoreCase("append")) {
                    fileOverwrite = true;
                    String outFilename = "playlist.txt";
                    File outFH = new File(outFilename);
                    FileWriter outFW = new FileWriter(outFH, true);
                    for (int i = 0; i < myPlaylist.size(); i++) {
                        System.out.println(myPlaylist.get(i));
                        outFW.write(": " + myPlaylist.get(i) + "\n");
                    }
                    outFW.close();
                    System.out.println("Finished writing to program at " + date1);
                    System.out.println("Please check playlist.txt to make sure that its there!");
                }
                else if (msg.equalsIgnoreCase("overwrite")) {
                    fileOverwrite = false;
                    String outFilename = "playlist.txt";
                    File outFH = new File(outFilename);
                    FileWriter outFW = new FileWriter(outFH, false);
                    for (int i = 0; i < myPlaylist.size(); i++) {
                        System.out.println(myPlaylist.get(i));
                        outFW.write(": " + myPlaylist.get(i) + "\n");
                    }
                    outFW.close();
                    System.out.println("Finished writing to program at " + date1);
                    System.out.println("Please check playlist.txt to make sure that its there!");
                }
            }

            // If the user chooses not to save the playlist,
            // the program will end
            else if (msg.equalsIgnoreCase("no")) {
                System.out.println("You just lost all your songs!");
                System.out.println("Its okay though, just restart...");
            }
        }

        // program ends because user didnt enter a numerical value
        catch (IOException IOE) {
            System.out.println("Could not write to file");
        }

        // Program ends here
        System.out.println("\nThanks for using my program!! :D");
    }

}