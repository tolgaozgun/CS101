/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 12/15/2020
 *
 * This program creates two instances of dice and compares
 * the values of them via a variety of methods.
 * 
 * The importance of toString() method is observed while
 * trying to print the die object.
 *
 */

public class TestDie {
	
	public static void main(String[] args) {
		//constants
		//variables
		Die dieOne;
		Die dieTwo;
		
		// Step 1: Create a new die.
		dieOne = new Die();
		
		// Step 2: Create an another die.
		dieTwo = new Die();
		
		// Step 3: Print the current values on both dice
		// using a variety of methods. 
		//
		// We can observe that by adding a toString() method,
		// trying to print the die object returns the face value
		// as we provided in the toString() method.
		System.out.println("===============");
		System.out.println("Die One: " + dieOne);
		System.out.println("-------");
		System.out.println("Die Two: " + dieTwo);
		System.out.println("===============");
		System.out.println("Die One: " + dieOne.getFaceValue());
		System.out.println("-------");
		System.out.println("Die Two: " + dieTwo.getFaceValue());
		System.out.println("===============");
	}

}
