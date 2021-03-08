/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 12/15/2020
 * 
 * This program simulates a dice rolling algorithm
 * in which the algorithm continues until it rolls
 * two sixes in total.
 * 
 */

public class LabSevenAOne {
	
	public static void main(String[] args) {
		//constants
		//variables
		int numberOfSixes;
		int randomNumber;
		numberOfSixes = 0;
		
		// Step 1: Create a loop that will continue until
		// two sixes are rolled.
		while ( numberOfSixes < 2 ) {
			
			// Step 2: Roll a random number from 1 to 6 inclusive.
			// This simulates a die roll.
			randomNumber = ( (int) (Math.random() * 6) ) + 1;
			
			// Step 3: Print the rolled number.
			System.out.println("Rolled: " + randomNumber);
			
			// Step 4: Increment the number of sixes if the rolled 
			// number is six.
			if ( randomNumber == 6 ) {
				numberOfSixes = numberOfSixes + 1;
			}
		}
	}
}
