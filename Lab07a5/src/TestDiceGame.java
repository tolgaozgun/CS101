/**
 * 
 * @author Tolga Ozgun
 * @version 1.0, 12/15/2020
 *
 * This program creates a DiceGame and 
 * prints out how many times the dice has
 * to be rolled until double six appears
 * on the top.
 *
 */

public class TestDiceGame {

	public static void main(String[] args) {
		int rollCount;
		DiceGame diceGame;
		
		// Step 1: Initiate the DiceGame instance.
		diceGame = new DiceGame();
		
		// Step 2: Roll the dices until double six appears on the top.
		// Get the amount of re-rolls.
		rollCount = diceGame.play();
		
		// Step 3: Print the amount of re-rolls.
		System.out.println("The amount of re-rolls done until double six is rolled: " + rollCount);
	}
}
