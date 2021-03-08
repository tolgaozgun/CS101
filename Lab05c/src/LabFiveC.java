import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 11/25/2020
 * 
 * This program is actually a simple calculator which 
 * displays instructions after every calculation. 
 * 
 * User can also
 * 
 * clear > Clearing the current result, making it equal to 0.0
 * quit > Get out of the calculator loop, ending the program.
 * 
 */

public class LabFiveC {

	
	public static void main(String[] args) {
		// constants
		// variables
		double result;
		int userInt;
		char operator;
		String userValue;
		Scanner scan;

		scan = new Scanner(System.in);
		
		// Step 1: Print a welcome message and show instructions to the user
		System.out.println("Welcome to \"SimpleCalc\"...");
		result = 0.0;
		reportCurrent(result);
		
		// Step 2: Get user value and check it. If,
		// > it is 'quit', go out of this loop.
		// > it is 'clear', make result equal to 0.
		// > it is an operator and a number, do the calculation as requested by user.
		// If the loop is continued, print the instructions again along with result.
		userValue = scan.nextLine();
		
		while( !userValue.equalsIgnoreCase("quit") && !userValue.equalsIgnoreCase("q") ) {
			if ( userValue.equalsIgnoreCase("clear") || userValue.equalsIgnoreCase("c") ) {
				result = 0.0;
			} else {
				operator = userValue.charAt(0);
				
				if ( operator == '/') { 
					userInt = getIntFromString(userValue);
					// Check if user is trying to divide by 0.
					if( userInt == 0 ) {
						System.out.println("Cannot divide by 0");
					} else {
						result = result / userInt;
					}
				} else if ( operator == '*' ){
					userInt = getIntFromString(userValue);					
					result = result * userInt;
				} else if ( operator == '-' ) {
					userInt = getIntFromString(userValue);					
					result = result - userInt;
				} else if ( operator == '+' ) {
					userInt = getIntFromString(userValue);					
					result = result + userInt;
				}
			}
			reportCurrent(result);
			userValue = scan.nextLine();
		}
		scan.close();
		
		// Step 3: Print goodbye message.
		System.out.println("Thanks for using \"SimpleCalc\", goodbye.");
	}
	
	
	/**
	 * This function prints out the instructions and
	 * displays the current result.
	 * 
	 * @param result   the current result on the calculator
	 * 
	 */
	
	public static void reportCurrent(double result) {
		System.out.println("------------------");
		System.out.println("[ " + result + " ]");
		System.out.println("------------------");
		System.out.println("  +,-,*,/ value\r\n" + "  Clear\r\n" + "  Quit");
		System.out.println("------------------");
		System.out.print("Select: ");
	}
	
	/**
	 * This converts the String provided 
	 * by user to an integer.
	 * 
	 * 
	 * @param userValue   the String provided by user.
	 * @return            the converted integer value 
	 * 
	 */
	
	public static int getIntFromString(String userValue) {
		userValue = userValue.substring(1).strip();
		return Integer.parseInt(userValue);
	}
}
