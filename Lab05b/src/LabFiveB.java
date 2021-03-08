import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 11/25/2020
 * 
 * This program prints out four different types of tables by getting 
 * number of rows and columns from the user.
 * 
 * Tables are as following:
 * 
 *  - table with each cell containing row and column numbers.
 *  - a simple multiplication table.
 *  - table with each cell containing a cell number incrementing from 0.
 *  - table with first column in each row containing the current row
 *  number. Other cells are filled with '-' (dash).
 *  
 *  Tables do keep spacing by limiting the number of characters
 *  in each cell to 6 by adding enough spaces when needed.
 *
 */

public class LabFiveB {
	
	public static void main(String[] args) {
		
		//constants
		
		//variables
		int rows;
		int columns;
		String lineString;
		Scanner scan;
		
		scan = new Scanner(System.in);
		
		// Step 1: Get the number of rows from the user.
		System.out.println("Enter the number of rows: ");
		rows = scan.nextInt();
		
		// Step 2: Get the number of columns from the user.
		System.out.println("Enter the number of columns: ");
		columns = scan.nextInt();
		
		scan.close();
		
		// Step 3: Build a table by printing out the row 
		// and column values in each cell. Make sure each 
		// cell's character length is equal to 6 by adding spaces.
		System.out.println("Task One: Columns and Numbers\n");
		
		for( int currentRow = 1; currentRow <= rows; currentRow++ ) {
			for( int currentColumn = 1; currentColumn <= columns; currentColumn++ ) {
				lineString = currentRow + "," + currentColumn;
				while ( lineString.length() < 6) {
					lineString = " " + lineString;
				}
				System.out.print(lineString);
			}
			System.out.print("\n");
		}
		
		// Step 4: Build a multiplication table by dividing the row 
		// and column values in each cell. Make sure the cell's 
		// character length is equal to 6 by adding spaces.
		System.out.println("\nTask Two: Multiplication Table\n");
		
		for( int currentRow = 1; currentRow <= rows; currentRow++ ) {
			for( int currentColumn = 1; currentColumn <= columns; currentColumn++ ) {
				lineString = currentRow * currentColumn + "";
				while ( lineString.length() < 6) {
					lineString = " " + lineString;
				}
				System.out.print(lineString);
			}
			System.out.print("\n");
		}
		
		// Step 5: Build a cell number's table by counting from 0 
		// and incrementing for each cell. Display the current value
		// as cell number, creating a table. Make sure each cell's
		// character length is equal to 6 by adding spaces.
		System.out.println("\nTask Three: Cell Numbers' Table\n");
		
		for( int currentRow = 0; currentRow < rows; currentRow++ ) {
			for( int currentColumn = 0; currentColumn < columns; currentColumn++ ) {
				lineString = currentRow * columns + currentColumn + "";
				while ( lineString.length() < 6) {
					lineString = " " + lineString;
				}
				System.out.print(lineString);
			}
			System.out.print("\n");
		}
		
		// Step 6: Build a table with only first columns containing
		// the current row number. Add dashes for remaining columns.
		// Make sure each cell's character length is equal to 6
		// by adding spaces.
		System.out.println("\nTask Four: Table With Dashes\n");

		for( int currentRow = 1; currentRow <= rows; currentRow++ ) {
			for( int currentColumn = 1; currentColumn <= columns; currentColumn++ ) {
				if ( currentColumn == 1 ) {
					lineString = currentRow + "";
				} else {
					lineString = "-";
				}
				while ( lineString.length() < 6) {
					lineString = " " + lineString;
				}
				System.out.print(lineString);
			}
			System.out.print("\n");
		}
		
	}
}
