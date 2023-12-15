/**
 * A custom exception for the Song object.
 * It will be thrown if there is an attempt to create
 * an invalid Song object. 
 */

public class SongException extends Exception {
   
   /** This message that outputs when the exception happens */
   private String message = "";
   
   /**
    * Constructs an exception
    */
    public SongException() {
      // Empty Constructor
    }
    
    /** Accessor/get Method */
    public String getMessage() {
      return this.message;
    }
    
    /** Mutator/set Method */
    public void setMessage(String newMessage) {
      this.message = newMessage;
    }
   
}
