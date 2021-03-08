import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 12/15/2020
 *
 * This program creates an instance of Dice object
 * which creates two dice for the user. The program 
 * rolls the two dice separately and displays their values.
 * This goes on until the user wants to stop.
 *
 */

public class TestDice {
	
	public static void main(String[] args) {
		//constants
		//variables
		Dice dice;
		Scanner scan = new Scanner(System.in);
		
		// Step 1: Create a new Dice instance that creates
		// two dice and rolls them.
		dice = new Dice();
		
		// Step 2: Print the value of die number one.
		System.out.println("Die One: " + dice.getDieOneFaceValue());
		
		// Step 3: Print the value of die number two.
		System.out.println("Die Two: " + dice.getDieTwoFaceValue());
		
		// Step 4: Print the sum of these two dice.
		System.out.println("Total Rolled: " + dice);
		// The following line does the same thing.
		// System.out.println("Total Rolled: " + dice.getDiceTotal());

		// Step 5: Ask if the user wants to continue
		System.out.print("Do you want to continue (Y/N): ");
		
		// Step 6: Based on the input, create a loop in which 
		// dice are rolled until the user wants to quit.
		while ( scan.hasNext() && scan.nextLine().toLowerCase().contains("y") ) {
			dice.roll();

			// Step 6.1: Print the value of die number one.
			System.out.println("Die One: " + dice.getDieOneFaceValue());
			
			// Step 6.2: Print the value of die number two.
			System.out.println("Die Two: " + dice.getDieTwoFaceValue());
			
			// Step 6.3: Print the sum of these two dice.
			System.out.println("Total Rolled: " + dice);
			System.out.print("Do you want to continue (Y/N): ");
		}
		scan.close();
	}

}
