import java.io.File;
import java.io.IOException;
import java.util.Scanner;


/**
 * 
 * 
 * @author Tolga Ozgun
 * @version 1.2, 11/25/2020
 * 
 * 
 *  This program takes a file full
 *  of integers and calculates sum, average, 
 *  minimum and maximum of these integers 
 *  until a negative value is read.
 * 
 *  WARNING:
 *  The file must include a negative number
 *  for this program to work!
 *
 */

public class LabFourG {
	
	public static void main(String[] args) throws IOException {
		// constants
		// variables
		Scanner dataInputFile;
		int sum;
		int iterator;
		int currentValue;
		int minimum;
		int maximum;
		double average;
		
		// Step 1: Initialize the scanner instance to read from the file.
		// In this example, we will be using 'testdata.txt'.
		dataInputFile = new Scanner( new File( "testdata.txt") );
		
		// Step 2: Read values and calculate sum, average, minimum, and maximum.
		// Reading the first value out of loop to save it as both minimum
		// and maximum. So that later on, we can compare upcoming values to
		// find the real minimum and maximum.
		//
		// This allows us to have a starting point. Otherwise, since we
		// cannot check if integers are null, we need to assign a random
		// number to this int and it will not be reliable.
		sum = 0;
		iterator = 0;
		currentValue = dataInputFile.nextInt();
		minimum = currentValue;
		maximum = currentValue;
		
		while ( currentValue >= 0 ) {
				if ( minimum > currentValue ) {
					minimum = currentValue;
				}
				if ( maximum < currentValue ) {
					maximum = currentValue;
				}
				sum = sum + currentValue;
				currentValue = dataInputFile.nextInt();
				iterator = iterator + 1;
		}
		average = sum / iterator;
		dataInputFile.close();
		
		// Step 3: Report the sum, average, minimum and maximum.
		System.out.println("Sum equals: " + sum
							+ "\nAverage equals: " + average
							+ "\nMaximum equals: " + maximum
							+ "\nMinimum equals: " + minimum);
	}
}
