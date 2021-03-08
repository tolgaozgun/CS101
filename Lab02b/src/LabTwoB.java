import java.util.Scanner;

/**
 * @author Tolga Özgün
 * @version 1.2, 11/25/2020
 * 
 * This program takes user input for their name
 * and then prints a personalized message.
 * 
*/


public class LabTwoB{
        public static void main(String[] args) {
            String yourName;
            
            // Step 1: Get user input for their name.
            System.out.println("Hello, please enter your name: ");
            Scanner scan = new Scanner(System.in);
            yourName = scan.nextLine();
            
            scan.close();
            
            // Step 2: Print a personalized message for the user with their name.
            System.out.print("Hello ");
            System.out.print(yourName);
            System.out.println( ", what a nice day to be alive!");
            
        }
}
