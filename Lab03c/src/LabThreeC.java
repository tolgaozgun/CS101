import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.3, 11/26/2020
 * 
 * This program creates a webpage for an employee
 * with given values of their name, age, salary, a
 * comment and tax rate about them. This program
 * also calculates the net salary the employee gets
 * and displays it.
 * 
 * 
 * Also this program displays their picture if their
 * name.jpg file exists in the file directory.
 * 
 * Outputs the finished HTML to temp.html in the file directory.
 *
 */

public class LabThreeC {
    public static void main(String[] args) throws IOException {
    	// constants
    	final String REPLACE_YOUR_NAME = "%YOUR_NAME%";
    	final String REPLACE_YOUR_NAME_LOWERCASE = "%YOUR_NAME_LOWERCASE%";
    	final String REPLACE_AGE = "%AGE%";
    	final String REPLACE_SALARY = "%SALARY%";
    	final String REPLACE_COMMENTS = "%COMMENTS%";
    	final String REPLACE_TAX_RATE = "%TAX_RATE%";
    	
    	// variables
        String yourName;
        String comments;
        String html;
        String imgHtml;
        String filePath;
        double salary;
        double netSalary;
        int age;
        int taxRate;
        File myObj;
        FileWriter myWriter;
        
		myObj = new File("temp.htm");
		myWriter = new FileWriter("temp.htm");
       
        html = "<!DOCTYPE html>\r\n\r\n<html>\r\n<head>\r\n" + 
        "<title> %YOUR_NAME%'s Home Page</title>\r\n" + 
        "</head>\r\n\r\n<body>\r\n\r\n<hr>\r\n" + 
        "<h1>%YOUR_NAME%</h1>\r\n" + 
        "<p>Age: %AGE%</p>\r\n" + 
        "<p>Salary: %SALARY% (%%TAX_RATE%)</p>\r\n" + 
        "<p>Comments: %COMMENTS%</p>\r\n" + 
        "<hr><img src=\"%YOUR_NAME_LOWERCASE%.jpg\"/>\r\n\r\n</body>\r\n\r\n</html>";
        imgHtml = "<img src=\"%YOUR_NAME_LOWERCASE%.jpg\"/>";
        
        // Step 1: Get employee's name.        
        Scanner scan = new Scanner(System.in);
        System.out.print("Hello, please enter employee's name: ");
        yourName = scan.nextLine();
        
        // Step 2: Get a comment about the employee.
        System.out.print("Enter a comment about the employee:");
        comments = scan.nextLine();
        
        // Step 3: Get employee's age.
        System.out.print("Please enter employee's age: ");
        age = scan.nextInt();
        
        // Step 4: Get employee's salary. 
        // If it's higher than $10.000, quit the program.
        System.out.print("Please enter employee's salary: ");
        salary = scan.nextDouble();
        scan.close();
        
        if ( salary > 10000 ) {
        	System.out.println("Salary cannot be higher than 10000!");
        } else {
        	
        	// Step 5: Calculate the tax rate according to the gross salary.
        	// If:
        	// salary is lower than 1000, tax rate equals 5%
        	// salary is higher than 5000, tax rate equals 25%
        	// anything else, tax rate equals 15%
    		if (salary < 1000) {
    			taxRate = 5;
    		} else if (salary > 5000) {
    			taxRate = 25;
    		} else {
    			taxRate = 15;
    		}

    		// Step 6: Calculate net salary based on the tax rate.
            netSalary = ( salary - 100 ) * ( 100 - taxRate ) / 100;
            
            // Step 7: Change the HTML with the values provided about the employee.
            // Remove the <img> tag if image file does not exist.
    		filePath = yourName.toLowerCase() + ".jpg";
    		if (!Files.exists(Paths.get(filePath))) {
    			// Removes the <img> tag.
    			html = html.replaceAll(imgHtml, "");
    		}
            
            html = html.replaceAll( REPLACE_YOUR_NAME, yourName )
        			.replaceAll( REPLACE_YOUR_NAME_LOWERCASE, yourName.toLowerCase() )
                    .replaceAll( REPLACE_AGE, age + "" )
                    .replaceAll( REPLACE_SALARY, netSalary + "")
                    .replaceAll( REPLACE_COMMENTS, comments )
                    .replaceAll( REPLACE_TAX_RATE, taxRate + "");
            
            // Step 8: Write the HTML page to temp.htm file.
			myObj.createNewFile();
			myWriter.write(html);
			myWriter.close();
			System.out.println("Webpage created.");
        }
    }
}