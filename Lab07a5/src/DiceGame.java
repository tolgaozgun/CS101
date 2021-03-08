/**
 * 
 * @author Tolga Ozgun
 * @version 1.0, 12/15/2020
 * 
 * This class creates a dice game in which
 * the dice are rolled until two sixes appear
 * on the top. The amount of re-rolls are returned.
 *
 */

public class DiceGame {
	
	private Dice dice;
	
	/**
	 * Initiates dice object and rolls them.
	 */
	public DiceGame() {
		dice = new Dice();
	}
	
	/**
	 * This method re-rolls the dice until it rolls 12 and
	 * returns the amount of re-rolls done.
	 * 
	 * @return	The amount of re-rolls.
	 */
	public int play() {
		int times;
		// this starts with 1 because the dice are rolled in declaration.
		times = 1; 
		
		// Step 1: Loop the sequence as long as the sum of the numbers
		// are smaller than 12.
		while ( dice.getDiceTotal() < 12 ) {
			
			// Step 1.2: Roll the dice again.
			dice.roll();
			
			// Step 1.3: Increment the amount of re-rolls by 1.
			times = times + 1;
		}
		return times;
	}
}
