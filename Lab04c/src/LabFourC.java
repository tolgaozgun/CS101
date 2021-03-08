/**
 * 
 * 
 * @author Tolga Ozgun
 * @version 1.1, 11/24/2020
 *
 *
 *	This program is a test to see the difference between 
 *
 *  while ( d == 1.0 ) 
 *  
 *  and 
 *  
 *  while ( d < 1.0 )
 *  
 *  
 *  One should refrain from using == with doubles and floats,
 *  since they may not be reliable when doing addition and subtraction. 
 */

public class LabFourC {
	
	public static void main(String[] args) {
		// constants
		
		// variables
		double d;
		
		d = 0.1;
		
		// Testing to see the difference between d == 1.0 and d < 1.0
		while ( d < 1.0 ) {
		   System.out.println(d);
		   d = d + 0.1;
		}
		
		System.out.println( d + " <- final value after loop!");
	}

}
