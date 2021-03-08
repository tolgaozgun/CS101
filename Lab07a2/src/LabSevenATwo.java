import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 12/15/2020
 * 
 * This program simulates a dice rolling algorithm
 * in which the user provides the number of dice to
 * be rolled, and program continues until the user
 * tells it to stop.
 * 
 */

public class LabSevenATwo {
	
	public static void main(String[] args) {
		//constants
		//variables
		Scanner scan = new Scanner(System.in);
		int diceAmount;
		
		// Step 1: Get the amount of dice that will be rolled.
		System.out.print("Enter the amount of dice to be rolled: ");
		diceAmount = scan.nextInt();
		scan.nextLine();

		// Step 2: Roll the dice and print the values to the user.
		rollDices(diceAmount);
		
		// Step 3: Ask the user if they want to continue
		System.out.print("Do you want to continue (Y/N): ");

		// Step 4: Continue the loop if the user wants to continue
		while ( scan.hasNext() && scan.nextLine().toLowerCase().contains("y") ) {
		
			rollDices(diceAmount);
			System.out.print("Do you want to continue (Y/N): ");
		}
		scan.close();
	}
	
	/**
	 * 
	 * This method rolls entered number of dice and prints
	 * their values out to console.
	 * 
	 * @param diceAmount	The amount of dice to be rolled
	 */
	
	public static void rollDices(int diceAmount) {
		//constants
		//variables
		int randomNumber;

		// Step 1: Enter a loop for the number of dice.
		while ( diceAmount > 0 ) {
			
			// Step 2: Generate a new number from 1 to 6 inclusive
			// that simulates a die roll.
			randomNumber = ( (int) (Math.random() * 6) ) + 1;
			
			// Step 3: Print out the die number and the rolled 
			// value to the user
			System.out.println("Die no " + diceAmount + " rolled: " + randomNumber);
			
			// Step 4: Decrease the amount of dice left to roll.
			diceAmount = diceAmount - 1;
		}
	}
}
