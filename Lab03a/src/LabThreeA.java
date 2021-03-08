

import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.3, 11/26/2020
 * 
 * This program takes all integers from 0 to 50 and for each,
 *  >  prints "out of range 12-25" whenever it's not between 12 and 25 inclusive.
 *  >  counts the number of odd and even numbers
 *  >  prints messages according to the numbers they can be divided by.
 *  >  finds the sum of numbers.
 *
 */

public class LabThreeA {
	
	public static void main(String[] args) {
		
		// constants
		// varibles
		int odd;
		int even;
		int n;
		int sum;
		int realSum;
		Scanner scanner;
		
		sum = 0;
		odd = 0;
		even = 0;
		n = 0;
		
		// Step 1: Get a value between 0-50 from the user.
		System.out.println( "Please enter a value between 0-50" );
		scanner = new Scanner(System.in);
		n = scanner.nextInt();
		scanner.close();
		
		for ( int x = 0; x <= 50; x++ ){
			// Step 2: Print the current value of x.
			System.out.print( x );
			
			// Step 3: If x is not between 12 and 25 inclusive, print 'out of range 12-25'
			if( x < 12 || x > 25 ) {
				System.out.print( " out of range 12-25" );	
			}
			System.out.println();
			
			// Step 4: Count the number of odd and even values of x.
			if( x % 2 == 0 ) {
				even++;
			}else {
				odd++;
			}
			
			// Step 5: if x is multiple of 5 print the message "Hi Five", 
			// else if it is divisible by 2 print the message "Hi Two", 
			//else if it is divisible by 3 or 7 print the message "Hi ThreeOrSeven", 
			// else  print the message "Hi Others!".
			if( x % 5 == 0 ) {
				System.out.println( "Hi Five" );
			}else if( x % 2 == 0 ){
				System.out.println( "Hi Two" );
			}else if( x % 3 == 0 || x % 7 == 0 ) {
				System.out.println( "Hi ThreeOrSeven" );
			}else {
				System.out.println( "Hi Others" );
			}
			
			// Step 6: Find the sum of values from 1 to n inclusive.
			if(n >= x) {
				sum+=x;
			}
		}
		
		// Step 7: Calculate the sum of the values from 1 to n inclusive using
		// n*(n+1)/2 formula.
		realSum = ( n * (n + 1) ) / 2;
		
		// Step 8: Report all the calculated values.
		System.out.println( "Count of even numbers: " + even  
				+ "\nCount of odd numbers: " + odd
				+ "\nSum of numbers until " + n + " equals: " + sum
				+ "\nSum should equal (according to formula): " + realSum);

	}
}
