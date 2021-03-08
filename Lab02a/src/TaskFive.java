import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 11/25/2020
 * 
 * This program asks user for their name and
 * then prints their name with a personalized
 * message.
 *
 */

public class TaskFive {
    public static void main(String[] args) {
    	//constants
    	//variables
        String yourName;
        Scanner scan;
        
        scan = new Scanner(System.in);
        
        // Step 1: Ask user for their name and get their name
        System.out.println("Hello, please enter your name: ");
        yourName = scan.nextLine();
        scan.close();
    	
        // Step 2: Print the user's name with a personalized message.
        System.out.print("Hello ");
        System.out.print(yourName);
        System.out.println( ", welcome to Java!");
        
    }
}
