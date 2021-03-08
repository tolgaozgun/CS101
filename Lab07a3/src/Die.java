/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 12/15/2020
 * 
 * A simple die class that can roll random values,
 * and return the last rolled value.
 *
 */

public class Die {
	
	private int faceValue;
	
	/**
	 * Rolls the die whenever it is initiated.
	 */
	public Die() {
		roll();
	}
	
	/**
	 * Rolls the die so that the current value
	 * on top of its face is randomized a value
	 * from 1 to 6 inclusive, simulating a die
	 * roll.
	 */
	public void roll() {
		faceValue = ( (int) (Math.random() * 6) ) + 1;
	}
	
	/**
	 * This method returns the current value on the die.
	 * 
	 * @return	The current value on the die.
	 */
	public int getFaceValue() {
		return faceValue;
	}
	
	/**
	 * 
	 * This method overrides the default toString() method
	 * of Java, and returns the current value on the die.
	 * 
	 * @return 	The current value on the die.
	 */
	@Override
	public String toString() {
		return Integer.toString(faceValue);
	}
}
