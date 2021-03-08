/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 12/15/2020
 * 
 * This class is a simple Dice class, which creates
 * two instances of Die class and rolls a dice for each.
 * 
 * This can get face values for each dice and their sum as
 * a total or roll them again.
 *
 */

public class Dice {
	
	private Die dieOne;
	private Die dieTwo;
	
	/**
	 * Constructor for this class.
	 * Rolls both of the dice.
	 */
	public Dice() {
		dieOne = new Die();
		dieTwo = new Die();
	}
	
	/**
	 * This method rolls the dice again and returns 
	 * the sum of their new values.
	 * 
	 * @return 	The sum of both dice's face values.
	 */
	public int roll() {
		dieOne.roll();
		dieTwo.roll();
		return getDiceTotal();
	}
	
	/**
	 * This method returns the face value of dice number one.
	 * 
	 * @return	 The face value of dice number one.		
	 */
	public int getDieOneFaceValue() {
		return dieOne.getFaceValue();
	}
	
	/**
	 * This method returns the face value of dice number two.
	 * 
	 * @return	 The face value of dice number two.		
	 */
	public int getDieTwoFaceValue() {
		return dieTwo.getFaceValue();
	}

	/**
	 * This method returns the sum of face values for these
	 * two dice.
	 * 
	 * @return	 The sum of face values.
	 */
	public int getDiceTotal() {
		return getDieOneFaceValue() + getDieTwoFaceValue();
	}
	
	/**
	 * This method returns the sum of face values for these
	 * two dice. It overrides the default Java method 
	 * toString() for this class.
	 * 
	 * @return	 The sum of face values.
	 */
	@Override
	public String toString() {
		return Integer.toString( getDiceTotal() );
	}

}
