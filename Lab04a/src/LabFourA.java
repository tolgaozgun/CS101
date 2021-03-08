import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 11/24/2020
 * 
 * This program does seven basic tasks.
 * 
 *  1. Outputs the integer values from 0 up to n exclusive. 
 *  It appears on a single line with values separated by a space.
 *  
 *  2. Outputs the integer values from 0 up to n exclusive. 
 *  The output has five values per line, with values separated by a space.
 *  
 *  3. Outputs the integer values from n down to 0 inclusive. 
 *  Output appears on a single line with values separated by a space.
 *  
 *  4. Outputs the even values from -n up to n inclusive. 
 *  Output appears on a single line with values separated by a space.
 *  
 *  5. Outputs the squares of the even values from 0 up to n inclusive.
 *  Output is separated by spaces, and has five numbers per line.  
 *  
 *  6. Outputs the values which are divisible by 3 or 4, but not both, 
 *  from n down to 3 inclusive. Output is separated by spaces, 
 *  and has five numbers per line
 *  
 *  7. Outputs all of the divisors of n.
 *  
 */

public class LabFourA {
	
	public static void main(String[] args) {
		// Constants
		final int MAX_NUMBERS_PER_LINE = 5;
		
		// Variables
		int n;
		int iterator;
		int valuesPrinted;
		Scanner scan;
		
		scan = new Scanner(System.in);
		
		// Step 1: Get user input
		System.out.println("Please enter a number: ");
		n = scan.nextInt();
		scan.close();
		
		// Step 2: Write a while loop to output the integer values from 0 up to n exclusive. 
		// Have the output appear on a single line with values separated by a space.
		System.out.println(" -- TASK ONE STARTS -- ");
		iterator = 0;
		while ( iterator < n ) {
			System.out.print(iterator + " ");
			iterator = iterator + 1;
		}
		System.out.print("\n -- TASK ONE ENDS --- \n");
		
		// Step 3: Write a while loop to output the integer values from 0 up to n exclusive. 
		// The output should have five values per line, with values separated by a space.
		System.out.println(" -- TASK TWO STARTS -- ");
		iterator = 0;
		valuesPrinted = 0;
		while ( iterator < n ) {
			if ( valuesPrinted == MAX_NUMBERS_PER_LINE ) {
				System.out.println();
				valuesPrinted = 0;
			}
			System.out.print(iterator + " ");
			valuesPrinted = valuesPrinted + 1;
			iterator = iterator + 1;
		}
		System.out.print("\n -- TASK TWO ENDS -- \n");
		
		// Step 4: Write a while loop to output
		// the integer values from n down to 0 inclusive.
		// Have the output appear on a single line 
		// with values separated by a space.
		System.out.println(" -- TASK THREE STARTS -- ");
		iterator = n;
		while ( iterator >= 0 ) {
			System.out.print(iterator  + " ");
			iterator = iterator - 1;
		}
		System.out.print("\n -- TASK THREE ENDS --\n");
		
		// Step 5: Write a while loop to output 
		// the even values from -n up to n inclusive. 
		// Have your output appear on a single line 
		// with values separated by a space.
		System.out.println(" -- TASK FOUR STARTS -- ");
		if ( n % 2 == 1 ) {
			iterator = - ( n - 1 );
		}else {
			iterator = -n;
		}
		while ( iterator <= n ) {
			System.out.print( iterator + " ");
			iterator = iterator + 2;
		}
		System.out.print("\n -- TASK FOUR ENDS --\n");
		
		// Step 6: Write a while loop that outputs 
		// (separated by spaces, five numbers per line ) 
		// the squares of the even values from 0 up to n inclusive. 
		System.out.println(" -- TASK FIVE STARTS -- ");
		valuesPrinted = 0;
		iterator = 0;
		while ( iterator <= n ) {
			if ( valuesPrinted == MAX_NUMBERS_PER_LINE ) {
				System.out.println();
				valuesPrinted = 0;
			}
			System.out.print( iterator * iterator + " ");
			iterator = iterator + 2;
			valuesPrinted = valuesPrinted + 1;
		}
		System.out.print("\n -- TASK FIVE ENDS --\n");
		
		// Step 7: Write a while loop that outputs 
		// (separated by spaces, five numbers per line)
		// the values which are divisible by 3 or 4, but not both,
		// from n down to 3 inclusive.  
		// For example, if n is 12, it should display 9 8 6 4 3.
		System.out.println(" -- TASK SIX STARTS -- ");
		iterator = n;
		valuesPrinted = 0;
		while ( iterator >= 3 ) {
			if ( ( iterator % 4 == 0 || iterator % 3 == 0 ) && iterator % 12 != 0 ) {
				if ( valuesPrinted == MAX_NUMBERS_PER_LINE ) {
					System.out.println();
					valuesPrinted = 0;
				}
				System.out.print(iterator + " ");
				valuesPrinted = valuesPrinted + 1;
			}
			iterator = iterator - 1;
		}
		System.out.print("\n -- TASK SIX ENDS --\n");
		
		// Step 8: Write a while loop that outputs all of the divisors of n. 
		// For example, if n is 12, it should display 2 3 4 6 12.
		System.out.println(" -- TASK SEVEN STARTS -- ");
		iterator = 2;
		while ( iterator <= n ) {
			if ( n % iterator == 0 ) {
				System.out.print(iterator + " ");
			}
			iterator = iterator + 1;
		}
		System.out.print("\n -- TASK SEVEN ENDS --\n");
	}
}
