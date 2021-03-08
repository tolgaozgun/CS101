import java.util.Scanner;

/**
 * 
 * This class introduces basic functions in Math such as power,
 * factorial, converting base 10 to base 2 and converting base 2 to
 * base 10. It also includes reversing any String provided.
 * 
 * @author Tolga Ozgun
 * @version 1.1, 12/1/2020
 *
 */

public class LabSix {
	
	public static void main(String[] args) {
		//constants
		//variables
		int rows;
		int columns;
		int currentRow;
		int currentColumn;
		int decimalFirst;
		int decimalSecond;
		int result;
		int iterator;
		double numerator;
		double denominator;
		double multiplier;
		double taylorSum;
		double taylorCurrent;
		double taylorVariable;
		String cellString;
		String baseTwoFirst;
		String baseTwoSecond;
		String binaryResult;
		String lineInput;
		String lineLast;
		String currentWord;
		Scanner scan;
		
		scan = new Scanner(System.in);
		

		// Step 1: Get a line String to use in Task 4.
		System.out.print("Please enter a line to be reversed: ");
		lineInput = scan.nextLine();
		
		
		// Step 2: Get a base-2 value from the user to use in Task 3.
		System.out.print("Please enter a base-2 value: ");
		baseTwoFirst = scan.nextLine();
		
		// Step 3: Get the second base-2 value from the user to use in Task 3.
		System.out.print("Please enter an another base-2 value: ");
		baseTwoSecond = scan.nextLine();
		
		
		// Step 4: Get a integer value that represent a radian to use in Task 5-6.
		System.out.print("Please enter a radian value to get its sin of: ");
		taylorVariable = scan.nextDouble();
		scan.close();
		
		// Step 5: Print out a table that shows n, n squared, n cubed,
		// n to the power of 4 for values of n from -1 to 10 inclusive
		System.out.println("Task One: Printing Out a Table\n");
		
		columns = 4;
		rows = 10;
		
		for ( currentRow = -1; currentRow <= rows; currentRow++ ) {
			for ( currentColumn = 1; currentColumn <= columns; currentColumn++ ) {
				cellString = power(currentRow,currentColumn) + "";
				while ( cellString.length() < 14) {
					cellString = " " + cellString;
				}
				System.out.print(cellString);
			}
			System.out.print("\n");
		}
		
		
		// Step 6: Print out a table that contains n value on the first column
		// and factorial of n (n!) on the second column for the values of n
		// from 1 to 15 inclusive.
		System.out.println("\nTask Two: Printing Out a Factorial Table\n");

		columns = 2;
		rows = 15;
		
		for( currentRow = 1; currentRow <= rows; currentRow++ ) {
			for( currentColumn = 1; currentColumn <= columns; currentColumn++ ) {
				if ( currentColumn == 1 ) {
					cellString = currentRow + "";
				}else {
					cellString = factorial(currentRow) + "";
				}
				
				while ( cellString.length() < 12) {
					cellString = " " + cellString;
				}
				System.out.print(cellString);
			}
			System.out.print("\n");
		}
		
		// Step 7: Convert the two base-2 values that we got from the user
		// to decimal values and get the sum of them in decimal. Then,
		// convert this decimal value to binary and display it to user.
		System.out.println("\nTask Three: Addition of Two Base-2 Values\n");

		decimalFirst = toDecimal(baseTwoFirst);
		decimalSecond = toDecimal(baseTwoSecond);
		result = decimalFirst + decimalSecond;
		binaryResult = toBinary(result);
		System.out.println("The result of addition of " + baseTwoFirst 
				+ "|2 and " + baseTwoSecond + "|2 is " + binaryResult + "|2");

		
		// Step 8: Reverse the sentence that we got from the user
		// getting each word one by one so that the sequence of words
		// stay the same, but the words are inverted.
		System.out.println("\nTask Four: Reverse A Sentence\n");
		lineLast = "";
		currentWord = "";
		lineInput = lineInput + " ";
		iterator = 0;
		while ( iterator < lineInput.length() ) {
			if ( lineInput.charAt(iterator) != ' ' ) {
				currentWord = currentWord + lineInput.charAt(iterator);
			} else {
				if ( lineLast == "" ) {
					lineLast = reverse(currentWord);
				} else {
					lineLast = lineLast + " " + reverse(currentWord);
				}
				currentWord = "";
			}
			iterator = iterator + 1;
		}
		
		
		/*for( iterator = 0; iterator < lineInput.split(" ").length; iterator++ ) {
			lineLast = lineLast + reverse(lineInput.split(" ")[iterator]) + " ";
		}*/
		System.out.println(lineLast);

		/*
		 *  Step 9: Calculate sin(x) from the radian value we got 
		 *  from the user. Print out a table that displays each term on a column.
		 *  For more information about Taylor Series:
		 *  http://www.cs.bilkent.edu.tr/~david/cs101/assignments/lab06/taylorseries_sinx.png
		 *  Column 1 >> The value of n in Taylor Series. ( Current Row Number )
		 *  Column 2 >> Numerator (-1^n)
		 *  Column 3 >> x^(2n+1)
		 *  Column 4 >> Denominator (2n+1)!
		 *  Column 5 >> The value of nth term in Taylor Series
		 *  Column 6 >> The sum of terms calculated so far.
		 *  
		 */
		System.out.println("\nTask Five: Taylor Series Part One\n");
		
		columns = 6;
		rows = 10;
		multiplier = 1;
		numerator = 1;
		denominator = 1;
		taylorSum = 0;
		taylorCurrent = 0;
		
		for ( currentRow = 0; currentRow <= rows; currentRow++ ) {
			for ( currentColumn = 1; currentColumn <= columns; currentColumn++ ) {
				if ( currentColumn == 1 ) {
					cellString = Integer.toString(currentRow);
				} else if ( currentColumn == 2 ) {
					numerator = power(-1,currentRow);
					cellString = Double.toString(numerator);
				} else if ( currentColumn == 3 ) {
					multiplier = power(taylorVariable, 2 * currentRow + 1);
					cellString = Double.toString(multiplier);
				} else if ( currentColumn == 4 ) {
					denominator = factorial(2 * currentRow + 1);
					cellString = Double.toString(denominator);
				} else if ( currentColumn == 5 ) {
					taylorCurrent = numerator * multiplier / denominator;
					cellString = Double.toString(taylorCurrent);
				} else if ( currentColumn == 6 ) {
					taylorSum = taylorSum + taylorCurrent;
					cellString = Double.toString(taylorSum);
				} else {
					cellString = " ";
				}
				cellString = "    " + cellString;
				System.out.print(cellString);
			}
			System.out.print("\n");
		}
		
		/*
		 *  Step 10: Calculate sin(x) from the radian value we got 
		 *  from the user. Print out a table that displays each term on a column.
		 *  For more information about Taylor Series:
		 *  http://www.cs.bilkent.edu.tr/~david/cs101/assignments/lab06/taylorseries_sinx.png
		 *  
		 *  This method differs from the above in such way that it does not calculate
		 *  each term again, instead calculates it by multiplying and dividing 
		 *  the latest term with the values required.
		 *  
		 *  User can compare the values of sin(x) calculated by the Math library
		 *  and our method.
		 *  
		 */
		System.out.println("\nTask Six: Taylor Series Part Two\n");

		System.out.println("Math Library's result of sin(x):  " + Math.sin(taylorVariable));
		System.out.println("Our calculation of sin(x): " + sin(taylorVariable));
		
	}

	/**
	 * A simple method that calculates the power of a base value.
	 * 
	 * @param base 		The base value. x can be any real value.
	 * @param power 	The power value. y is a positive integer.
	 * @return			The result of this repeated multiplication.
	 */
	
	public static double power(double base, int power) {
		//variables
		double result;
		result = 1;
		
		while( power > 0 ) {
			result = result * base;
			power = power - 1;
		}
		return result;
	}
	
	/**
	 * 
	 * This simple method takes factorial of the provided values.
	 * 
	 * @param number	The number to take factorial of.
	 * @return			The result of the factorial
	 */
	
	public static long factorial(int number) {
		// variables
		long iterator;
		long result;
		
		result = 1;
		for (iterator = 1; iterator <= number; iterator++ ) {
			result = result * iterator;
		}
		
		return result;
	}
	
	/**
	 * This method takes a String and reverses with respect to the order of 
	 * letters in the word
	 * 
	 * @param message	The message to reverse
	 * @return			The reversed message
	 */
	
	public static String reverse(String message) {
		// variables
		int iterator;
		String reverseMessage;
		
		reverseMessage = "";
		for( iterator = message.length() - 1; iterator >= 0; iterator-- ) {
			reverseMessage = reverseMessage + message.charAt(iterator);
		}
		return reverseMessage;
	}
	
	/**
	 * This method converts a number in base 2 to its respected value in
	 * base 10.
	 * 
	 * @param base2		The String value of the number in base 2.
	 * @return			The converted number (in base 10) as an int.
	 */
	
	public static int toDecimal(String base2) {
		// variables
		int iterator;
		int tempValue;
		char ch;
		int decimalValue;
		
		decimalValue = 0;
		for(iterator = 0; iterator < base2.length(); iterator++) {
			ch = base2.charAt(base2.length() - 1 - iterator);
			tempValue = Integer.parseInt(String.valueOf(ch));
			decimalValue = decimalValue + (int) (power(2, iterator)) * tempValue;
		}
		return decimalValue;
	}
	
	/**
	 * This method converts a decimal value to its respected value in base 2.
	 * @param base10		The decimal value
	 * @return				The String type of the value in base 2.
	 */
	
	public static String toBinary(int base10) {
		// variables
		int result;
		int remainder;
		String endValue;
		
		result = 1;
		endValue = "";
		while ( result > 0 ) {
			result = base10 / 2;
			remainder = base10 % 2;
			endValue = endValue + remainder;
			base10 = result;
		}
		return reverse(endValue);
	}
	
	/**
	 * 
	 * This method calculates the sin of a radian value
	 * 
	 * @param x		The radian value
	 * @return		The sin value
	 */
	
	public static double sin(double x) {
		// variables
		int iterator;
		double taylorCurrent;
		double taylorSum;
		
		taylorSum = 0.0;
		taylorCurrent = 0.0;
		for( iterator = 0; iterator < 10; iterator++ ) {
			if ( iterator == 0 ) {
				taylorCurrent = x;
			} else {
				taylorCurrent = power(-1,iterator) * taylorCurrent * power(x,2) / (iterator * 2 * ( iterator * 2 + 1));
			}
			taylorSum = taylorSum + taylorCurrent;
		}
		return taylorSum;
	}
	
}
