import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.2, 11/25/2020
 * 
 * This program calculates the values of PI with the formula 
 * 
 * 'pi = 4/1 - 4/3 + 4/5 - 4/7 + 4/9 - ....'
 * 
 * with the number of terms provided by the user,
 * and until a specific error value provided by the user
 * matches the calculated PI value's difference than the
 * real PI value.
 *
 */

public class LabFiveD {

	public static void main(String[] args) {
		
		//constants
		final double PI = Math.PI;
		
		//variables
		int numberOfTerms;
		int i;
		double firstPI;
		double secondPI;
		double accuracy;
		Scanner scan;
		
		scan = new Scanner(System.in);
		
		// Step 1: Ask the error value calculating PI.
		System.out.print("Please enter max error value when calculating PI: ");
		accuracy = scan.nextDouble();
		
		// Step 2: Ask how many terms should we use to calculate PI.
		System.out.print("Please enter how many terms should be used to calculate PI: ");
		numberOfTerms = scan.nextInt();
		scan.close();
		
		// Step 3: Calculate PI with the amount of terms given by user.
		// According to the 'pi = 4/1 - 4/3 + 4/5 - 4/7 + ....' formula
		firstPI = 0;
		for( i = 1; i <= numberOfTerms; i++ ) {
			firstPI = firstPI - Math.pow(-1, i) * ( 4.0 / ( i * 2.0 - 1.0 ) );
		}
		
		// Step 4: Calculate PI so that it is error is lower than the
		// accuracy value provided by the user.
		// Use the formula: 'pi = 4/1 - 4/3 + 4/5 - 4/7 + ....'
		secondPI = 0;
		i = 1;
		
		while ( Math.abs( PI - secondPI ) > accuracy ) {
			secondPI = secondPI - Math.pow(-1, i) * ( 4.0 / ( i * 2.0 - 1.0 ) );
			i = i + 1;
		}
		
		// Step 5: Print the calculated PI values alongside the real value of PI.
		System.out.println("PI: " + PI + 
				"\nPI calculated to the " + numberOfTerms + " terms: " + firstPI + 
				"\nPI calculated to accuracy " + accuracy + ": " + secondPI);
		
	}
}
