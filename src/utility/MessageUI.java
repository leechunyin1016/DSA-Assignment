package utility;

/**
 *
 * @author Kat Tan
 */
public class MessageUI {
  
  
  public static void displayInvalidChoiceMessage() {
    System.out.println("\nInvalid choice");
  }

  public static void displayExitMessage() {
    System.out.println("\nExiting system");
  }
  
  public void whatNotFound(String input){
      System.out.println(input+" Not Found.");
  }
  
}
