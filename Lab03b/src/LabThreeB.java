import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.3, 11/26/2020
 * 
 * This program calculates the area for a triangle with given values for its sides.
 * Then it calculates how many plants can be planted at max in this area,
 * accepting that maximum 17 plants can be planted on each square meter.
 * 
 * In addition, it checks if the given values actually form a triangle
 * by using Triangle Inequality.
 *
 */

public class LabThreeB {
    
	public static void main(String[] args) {
		
		//constants
	    final int MAX_PLANTS_PER_SQUARE_METER = 17;
		
	    // variables
	    int maxPlants;
		int numberOne;
		int numberTwo;
		int numberThree;
	    double semiPerimeter;
	    double areaSquared;
	    double area;
	    Scanner scan;

	    scan = new Scanner(System.in);
	    
	    // Step 1: Get the first integer from the user
        System.out.println("Please enter a number: ");
        numberOne = scan.nextInt();
        
        // Step 2: Get the second integer from the user
        System.out.println("Please enter the second number: ");
        numberTwo = scan.nextInt();
        
        // Step 3: Get the second integer from the user
        System.out.println("Please enter the third number: ");
        numberThree = scan.nextInt();
	    scan.close();
	    
	    // Step 4: Check if the given values form a triangle
	    // using Triangle Inequality.
	    if( numberOne + numberTwo > numberThree && 
	    	numberOne + numberThree > numberTwo && 
	    	numberTwo + numberThree > numberOne ) {

		    // Step 5: Calculate the area using Heron's formula.
		    // Step 5.1: Calculate the semi-perimeter.
		    semiPerimeter = (numberOne + numberTwo + numberThree) / 2.0;
		    
		    // Step 5.2: Calculate the square of the area.
		    areaSquared = semiPerimeter * (semiPerimeter - numberOne) * (semiPerimeter - numberTwo)* (semiPerimeter - numberThree);
		    
		    // Step 5.3: Calculate the area by taking the square root of the previous value.
		    area = Math.sqrt(areaSquared);
		    
		    // Step 6: Calculate the max number of plants.
		    maxPlants = (int) Math.floor(area * MAX_PLANTS_PER_SQUARE_METER);
		    
		    // Step 7: Print out the area and max amount of plants that can be planted.
		    System.out.println("The area of the garden is: " + area);
		    System.out.println("Max amount of plants you can plant would be: " + maxPlants);
	    } else {
	    	System.out.println("The values provided do not form a triangle!");
	    }
    }
}