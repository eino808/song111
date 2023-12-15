/**
 * a class for modeling a Song
 *
 * @author Inofinada, Elijah
 */

public class Song {

    // set the instance variables
    private String title = "";
    private String artist = "";
    private int min = 0;
    private int sec = 0;

    /*
     * Constructor to create Song objects
     *
     * @param title    the song's title
     * @param artist   the song's artist
     * @param min      the song's length in minutes
     * @param sec      the song's length in seconds
     */
    public Song (String title, String artist, int min, int sec) throws Exception {
        this.setTitle(title);
        this.artist = artist;
        this.min = min;
        this.sec = sec;
    }

    /** Accessor methods**/
    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getMin() {
        return this.min;
    }

    public int getSec() {
        return this.sec;
    }

    /**
     * Mutator method to set a new Title value
     * newTitle must be greater than 1
     *
     *
     * @param         newTitle       The new title
     * @exception     DsException    if the length of the brand is less than 1
     */
    public void setTitle(String newTitle) throws Exception {
        if (newTitle.length() > 1) {
            this.title = newTitle;
        }
        else {
            // create the  Dsexception
            SongException se = new SongException();
            // create the error message
            se.setMessage("\t\t***ERROR ERROR ERROR*** " + "\n\t" + newTitle + " \tis not valid.");
            // throw the DsException
            throw se;
        }
    }

    /**
     * Mutator method to set a new Artist value
     * newArtist must be greater than 1
     *
     *
     * @param         newArtist       The new title
     * @exception     DsException    if the length of the brand is less than 1
     */
    public void setArtist(String newArtist) throws Exception {
        if (newArtist.length() > 1) {
            this.artist = newArtist;
        }
        else {
            // create the  Dsexception
            SongException se = new SongException();
            // create the error message
            se.setMessage("\t\t***ERROR ERROR ERROR*** " + "\n\t" + newArtist + " \tis not valid.");
            // throw the DsException
            throw se;
        }
    }

    /**
     * Mutator method to set a new Min value
     * newMin must be greater than 0 AND less than 60
     *
     *
     * @param         newMin         he new min value
     * @exception     DsException    if the length of the brand is less than 0 or greater than 60
     */
    public void setMin(int newMin) throws Exception {
        if (newMin > 0 && newMin  < 60) {
            this.min = newMin;
        }
        else {
            // create the  Dsexception
            SongException se = new SongException();
            // create the error message
            se.setMessage("\t\t***ERROR ERROR ERROR*** " + "\n\t" + newMin + " \tis not valid.");
            // throw the DsException
            throw se;
        }
    }

    /**
     * Mutator method to set a new sec value
     * newSec must be greater than 0 AND less than 60
     *
     *
     * @param         newSec         he new sec value
     * @exception     DsException    if the length of the brand is less than 0 or greater than 60
     */
    public void setSec(int newSec) throws Exception {
        if (newSec > 0 || newSec < 60) {
            this.sec = newSec;
        }
        else {
            // create the  Dsexception
            SongException se = new SongException();
            // create the error message
            se.setMessage("\t\t***ERROR ERROR ERROR*** " + "\n\t" + newSec + " \tis not valid.");
            // throw the DsException
            throw se;
        }
    }


    /*Return a printable string of the instance variables
     *For example, an object new Song("TR666", "Trippie Redd", 2, 23);
     *    Title: TR666 (2:23) by Trippe Redd
     *
     * @ return      output       A printable string of instance variables
     */
    public String toString() {
        String output = "";
        output += "\nTitle: " + this.title + " (" + this.min + ": " + this.sec + ") " + "by " + this.artist;
        return output;
    }
}