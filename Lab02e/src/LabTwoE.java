import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.3, 11/26/2020
 * 
 * This program creates a webpage for an employee
 * with given values of their name, age, salary and a
 * comment about them.
 *
 */

public class LabTwoE {
    public static void main(String[] args) {
    	// constants
    	final String REPLACE_YOUR_NAME = "%YOUR_NAME%";
    	final String REPLACE_AGE = "%AGE%";
    	final String REPLACE_SALARY = "%SALARY%";
    	final String REPLACE_COMMENTS = "%COMMENTS%";
    	
    	// variables
        String yourName;
        String comments;
        String html;
        double salary;
        int age;
       
        html = "<!DOCTYPE html>\r\n\r\n<html>\r\n<head>\r\n" + 
        "<title> %YOURNAME%'s Home Page</title>\r\n" + 
        "</head>\r\n\r\n<body>\r\n\r\n<hr>\r\n" + 
        "<h1>%YOURNAME%</h1>\r\n" + 
        "<p>Age: %AGE%</p>\r\n" + 
        "<p>Salary: %SALARY%</p>\r\n" + 
        "<p>Comments: %COMMENTS%</p>\r\n" + 
        "<hr>\r\n\r\n</body>\r\n\r\n</html>";
        
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
        System.out.print("Please enter employee's salary: ");
        salary = scan.nextDouble();
        scan.close();
        
        // Step 5: Change the HTML with the values provided about the employee.
        html = html.replaceAll( REPLACE_YOUR_NAME, yourName )
                .replaceAll( REPLACE_AGE, age + "" )
                .replaceAll( REPLACE_SALARY, salary + "")
                .replaceAll( REPLACE_COMMENTS, comments );
                    
        // Step 6: Print the HTML page.
        System.out.println(html);
    }
}
