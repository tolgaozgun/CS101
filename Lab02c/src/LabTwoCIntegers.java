import java.util.Scanner;


/**
 * 
 * @author Tolga Ozgun
 * @version 1.3, 11/25/2020
 * 
 * This program calculates all mathematical operational 
 * combinations between two given numbers
 * 
 * WARNING:
 * This version uses integers so calculations are rounded and will be wrong.
 * 
 * 
 */

public class LabTwoCIntegers {
	
    public static void main(String[] args) {
    	//constants
    	//variables
    	int numberOne;
    	int numberTwo;
    	int sum;
    	int subtractTwoFromOne;
    	int subtractOneFromTwo; 
    	int multiply;
    	int result;
        String divideTwoByOne;
        String divideOneByTwo;
        Scanner scan;

        scan = new Scanner(System.in);
        
        // Step 1: Get number one from the user.
        System.out.println("Please enter a number: ");
        numberOne = scan.nextInt();
        
        // Step 2: Get the second number from the user.
        System.out.println("Please enter an another number: ");
        numberTwo = scan.nextInt();
        scan.close();
        
        // Step 3: Calculate values of sum, subtraction, 
        // multiplication, division.        
        sum = numberOne + numberTwo;
        subtractTwoFromOne = numberTwo - numberOne;
        subtractOneFromTwo = numberOne - numberTwo;
        multiply = numberOne * numberTwo;
        
        if(numberOne == 0){
            divideTwoByOne = "undefined";
        }else{
            result = numberTwo / numberOne;
            divideTwoByOne = result+"";
        }
        
        if(numberTwo == 0){
            divideOneByTwo = "undefined";
        }else{
            result = numberOne / numberTwo;
            divideOneByTwo = result +"";
        }
        
        // Step 4: Print out the values to the user.
        System.out.println("Sum of these numbers: " + sum);
        System.out.println("Number 1 subtracted from Number 2: " + subtractTwoFromOne);
        System.out.println("Number 2 subtracted from Number 1: " + subtractOneFromTwo);
        System.out.println("Number 1 multiplied by Number 2: " + multiply);
        System.out.println("Number 1 divided by Number 2: " + divideOneByTwo);
        System.out.println("Number 2 divided by Number 1: " + divideTwoByOne);
    }
        
}
