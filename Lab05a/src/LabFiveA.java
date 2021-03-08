import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.2, 11/25/2020
 * 
 * This program takes values of width, height and thickness from the user
 * and prints out a shape by using '*' (asterisk). This program continues
 * in a loop until the user wants to exit.
 *
 */

public class LabFiveA {
	
	public static void main(String[] args) {
		// constansts
		// variables
		String userValue;
		Scanner scan;
		int width;
		int height;
		int thickness;
		boolean shouldContinue;
		
		shouldContinue = true;
		scan = new Scanner(System.in);
		
		// Step 1: Ask for width, height and thickness and get the values.
		// Make sure all values are different than 0.
		do {
			System.out.println("Enter width, height & thickness: ");
			userValue = scan.nextLine();
			
			width = Integer.parseInt(userValue.split(" ",3)[0]);
			height = Integer.parseInt(userValue.split(" ",3)[1]);
			thickness = Integer.parseInt(userValue.split(" ",3)[2]);
			
			if(width == 0 || height == 0 || thickness == 0) {
				System.out.println("Error: all values must be positive!");
			} else {
				
				// Step 2: Draw the shape according to the width, height, thickness
				for( int currentLine = 1; currentLine <= height; currentLine++ ) {
					for( int currentColumn = 1; currentColumn <= width; currentColumn++ ) {
						if( currentLine > thickness && currentLine <= height - thickness ) {
							// Check if this line should have a blank spot in the middle
							// In other words, check if this line is part of the frame.
							if( currentColumn > thickness && currentColumn <= width - thickness ) {
								// Check if this column is one of the blank columns.
								// In other words, check if this column is part of the frame.
								System.out.print(" ");
							} else {
								System.out.print("*");
							}
							
						} else {
							System.out.print("*");
						}
					}
					System.out.print("\n");
				}
			}	
			
			// Step 3: Ask user if they want to continue again. 
			// If yes, continue the loop.
			// If not, end the loop.
			System.out.println("Do you want to continue (Y/N): ");
			userValue = scan.nextLine();
			
			if(userValue.equalsIgnoreCase("n")) {
				shouldContinue = false;
			}
			
		} while( shouldContinue );
		
		scan.close();
	}
}
