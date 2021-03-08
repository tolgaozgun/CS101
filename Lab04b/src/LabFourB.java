import java.util.Scanner;

/**
 * 
 * 
 * @author Tolga Ozgun
 * @version 1.1, 11/24/2020
 *
 *
 * This program creates an ascending and descending triangle shape,
 * with the character and the width provided by the user.
 * 
 *  
 */

public class LabFourB {
	
	public static void main(String[] args) {
		// constants
		// variables
		char ch;
		int width;
		int iterator;
		int secondIterator;
		String charString;
		Scanner scan;
		
		scan = new Scanner(System.in);
		
		// Step 1: Get the character from the user.
		System.out.println("Please enter the character: ");
		charString = scan.nextLine();
		ch = charString.charAt(0);
		
		// Step 2: Get the width from the user.
		System.out.println("Please enter the width: ");
		width = scan.nextInt();
		
		scan.close();
		
		// Step 3: Print the ascending triangle according to the input.
		System.out.println("Ascending Triangle\n");
		iterator = 1;
		while ( iterator <= width ) {
			secondIterator = 0;
			while ( secondIterator < iterator ) {
				System.out.print(ch);
				secondIterator = secondIterator + 1;
			}
			System.out.println();
			iterator = iterator + 1;
		}

		// Step 4: Print the descending triangle according to the input.
		System.out.println("\n\nDescending Triangle\n");
		iterator = width;
		
		while ( iterator > 0 ) {
			secondIterator = iterator;
			while ( secondIterator > 0 ) {
				System.out.print(ch);
				secondIterator = secondIterator - 1;
			}
			System.out.println();
			iterator = iterator - 1;
		}
	}

}
