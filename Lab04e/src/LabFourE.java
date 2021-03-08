import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.2, 11/25/2020
 *
 * This program takes a file full
 * of integers [minimum 10000 values]
 * and calculates sum, average, 
 * minimum and maximum of these integers. 
 *
 */


public class LabFourE {
	
	public static void main(String[] args) throws IOException {
		// constants
		final int AMOUNT_OF_VALUES = 10000;
		
		// variables
		Scanner dataInputFile;
		int sum;
		int iterator;
		int currentValue;
		int maximum;
		int minimum;
		double average;
		
		// Step 1: Initialize the scanner instance to read from the file.
		// In this example, we will be using 'testdata.txt'.
		dataInputFile = new Scanner( new File( "testdata.txt") );
		
		// Step 2: Read values and calculate sum, average, minimum, and maximum.
		sum = 0;
		iterator = AMOUNT_OF_VALUES - 1;
		// Reading the first value out of loop to save it as both minimum
		// and maximum. So that later on, we can compare upcoming values to
		// find the real minimum and maximum.
		//
		// This allows us to have a starting point. Otherwise, since we
		// cannot check if integers are null, we need to assign a random
		// number to this int and it will not be reliable.
		currentValue = dataInputFile.nextInt();
		minimum = currentValue;
		maximum = currentValue;
		
		while ( iterator > 0 ) {
			currentValue = dataInputFile.nextInt();
			if ( minimum > currentValue ) {
				minimum = currentValue;
			}
			if ( maximum < currentValue ) {
				maximum = currentValue;
			}
			sum = sum + currentValue;
			iterator = iterator - 1;
		}
		average = sum / AMOUNT_OF_VALUES;
		dataInputFile.close();
		
		// Step 3: Report the sum, average, maximum and minimum.
		System.out.println("Sum equals: " + sum
							+ "\nAverage equals: " + average
							+ "\nMaximum equals: " + maximum
							+ "\nMinimum equals: " + minimum);
		
	}

}
