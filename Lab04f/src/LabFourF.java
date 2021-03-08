import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * 
 * @author Tolga Ozgun
 * @version 1.3, 11/26/2020
 * 
 * This program writes a user defined number of random integers to a file
 * whose name was also provided by the user.
 *
 */


public class LabFourF {
	
	public static void main(String[] args) throws IOException {
		// constants
		// variables
		int valueSize;
		int negativeValueSize;
		String fileName;
		PrintWriter fout;
		Scanner scan;
		File file;
		
		scan = new Scanner(System.in);
		
		// Step 1: Get file name from the user and create the file
		// if the file does not exist.
		System.out.println("Please enter the name of the file: ");
		fileName = scan.nextLine();
		file = new File(fileName);
		if ( !file.exists() ) {
			file.createNewFile();
		}
		fout = new PrintWriter(fileName);
		
		// Step 2: Get number of random values from the user
		System.out.println("Please enter the number of values you want: ");
		valueSize = scan.nextInt();
		
		// Step 3: Get number of negative values from the user
		System.out.println("Please enter the number of negative values you want: ");
		negativeValueSize = scan.nextInt();
		scan.close();
		
		// Step 4: Calculate the random values and write them to the file.
		while ( valueSize > 0 ) {
			fout.println(Math.random());
			valueSize = valueSize - 1;
		}
		
		fout.close();
	}

}
