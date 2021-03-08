/**
 * @author Tolga Ozgun
 * @version 1.2, 11/25/2020
 * 
 * 
 * This program takes user input for their name 
 * and their age, then prints them out.
 * 
 * 
*/

import java.util.Scanner;

public class TaskSix {
    public static void main(String[] args) {
        // constants
    	// variables
        int age;
        String yourName;
        Scanner scan;
        
        scan = new Scanner(System.in);
        
        // Step 1: Get user input for their name
        System.out.print("Hello, please enter your name: ");
        yourName = scan.nextLine();
        
        scan.close();
        
        // Step 2: Get user input for their age.
        System.out.print("Please enter your age: ");
        age = scan.nextInt();
        
        // Step 3: Print out a message with their name and age.
        System.out.print("Hello ");
        System.out.print(yourName);
        System.out.println( ", welcome to Java!");
        System.out.println("You are " + age + " years old!");
        
    }
}
