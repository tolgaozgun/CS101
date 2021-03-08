import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.3, 12/15/2020
 *
 * This program simulates a library of three books. 
 * With this program, you can loan and return these books
 * while also seeing the status of them too.
 *
 */

public class TestLibraryBook {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		LibraryBook bookOne;
		LibraryBook bookTwo;
		LibraryBook bookThree;
		LibraryBook bookFour;
		LibraryBook userBook;
		String userInput;
		String userCommand;
		String userBookString;
		String userDate;
		Date date;
		int bookInt;
		boolean firstRun;

		// Scanner will not work when the program is first run.
		// Instead of copying the whole code once more here
		// I added a boolean so that the while loop can start working.
		firstRun = true;
		userBook = null;
		userCommand = "";
		
		// Step 1: Create three books.
		bookOne = new LibraryBook("The Catcher in the Rye", "J.D Salinger");
		bookTwo = new LibraryBook("Lord of the Flies", "William Golding");
		bookThree = new LibraryBook("The Catcher in the Rye", "J.D Salinger");
		bookFour = bookOne;
		
		// Step 2: Check .equals() method and == comparator for these books.
		System.out.println("Compare 1 with 3 using ==         >> " + ( bookOne == bookThree ) );
		System.out.println("Compare 1 with 3 using .equals()  >> " + bookOne.equals(bookThree));
		System.out.println("Compare 1 with 2 using ==         >> " + ( bookOne == bookTwo ) );
		System.out.println("Compare 1 with 2 using .equals()  >> " + bookOne.equals(bookTwo));
		System.out.println("Compare 2 with 3 using ==         >> " + ( bookTwo == bookThree ) );
		System.out.println("Compare 2 with 3 using .equals()  >> " + bookTwo.equals(bookThree));
		System.out.println("Compare 1 with 4 using ==         >> " + ( bookOne == bookFour ) );
		System.out.println("Compare 1 with 4 using .equals()  >> " + bookOne.equals(bookFour));
		System.out.println("Compare 2 with 4 using ==         >> " + ( bookTwo == bookFour ) );
		System.out.println("Compare 2 with 4 using .equals()  >> " + bookTwo.equals(bookFour));
		
		// Step 3: Continue the loop until the user wants to stop.
		while ( firstRun || (scan.hasNext() && scan.nextLine().toLowerCase().contains("y")) ) {
			firstRun = false;
			
			// Step 4: Ask the user for their commands. If the book is not valid
			// loop this sequence.
			while ( userBook == null ) {
				// Step 4.1: Print the instructions to the user.
				printHelp();
				
				// Step 4.2: Get the instructions from the user.
				userInput = scan.nextLine();
				
				// User 4.3: Get the command and the book.
				userCommand = getWord(userInput, 1);
				userBookString = getWord(userInput, 2);
				bookInt = Integer.parseInt(userBookString);
				
				if ( bookInt == 1 ) {
					userBook = bookOne;
				} else if ( bookInt == 2 ) {
					userBook = bookTwo;
				} else if ( bookInt == 3 ) {
					userBook = bookThree;
				} 
			}
			
			// Step 5: Check if command is valid. If the command is one of
			// 'borrow, return, status' use the valid functions.
			if ( userCommand.equalsIgnoreCase("borrow") ) {
				// Step 5.1.1: If the book is loaned, tell user it is currently loaned
				if ( userBook.onLoan() ) {
					System.out.println(userBook.getTitle() + " is already borrowed! Come back later.");
				} else {
					// Step 5.1.2: If the book is not loaned, print the instructions
					// for getting a date.
					enterDate();
					
					// Step 5.1.3: From the user, get the date  
					// until which the book shall be borrowed 
					userDate = scan.nextLine();
					date = new SimpleDateFormat("MM/dd/yyyy").parse(userDate);
					userBook.loanBook(date);
				}
			} else if ( userCommand.equalsIgnoreCase("return") ) {
				// Step 5.2.1: If the book is not loaned, tell user it is not loaned.
				if( !userBook.onLoan() ) {
					System.out.println(userBook.getTitle() + " is not borrowed!");
				} else {
					// Step 5.2.2: If it is not loaned, return the book and print
					// a thank you message for the user.
					userBook.returnBook();
					System.out.println("Thanks for returning " + userBook.getTitle());
				}
			} else if ( userCommand.equalsIgnoreCase("status") ) {
				// Step 5.3.1: If the command is status,
				// bypass this if-else statement.
				//
				// Each loop will print the book's info anyway.
				// This part exists so that command status does not enter the 
				// else part where it says unknown command.
			} else {
				// Step 5.4.1: If the command is not one of the above,
				// it is invalid. Tell the user it is invalid.
				System.out.println("Unknown command.");
			}

			// Step 6: Print information about the specified book.
			printBook(userBook);
			userBook = null;
			
			// Step 7: Ask the user if they want to continue. If yes,
			// loop everything again.
			System.out.print("Can I help you with anything else (Y/N): ");
		}
		scan.close();
	}
	
	/**
	 * 
	 * This method displays information about the specified book.
	 * This information includes:
	 * title          - 	The title of the book
	 * author         -  	The author of the book
	 * is loaned      -		Check if the book is currently loaned
	 * is time passed -		Check if the book's due date is passed.
	 * times loaned   -		How many times has this book been loaned before.
	 * 
	 * @param book	The book of which the info will be displayed.
	 */
	public static void printBook(LibraryBook book) {
		System.out.println("==========================");
		System.out.println("Book Title: " + book.getTitle());
		System.out.println("Book Author: " + book.getAuthor());
		System.out.println("Is Book Loaned: " + book.onLoan());
		System.out.println("Is Loan Time Passed: " + book.isTimePassed());
		System.out.println("Book Times Loaned: " + book.getTimesLoaned());
		System.out.println("==========================");
	}
	
	/**
	 * This method prints the help that is printed
	 * each time the user continues to run the program.
	 */
	public static void printHelp() {
		System.out.println("==========================");
		System.out.println("Available books:");
		System.out.println("1: The Catcher in the Rye - J. D. Salinger");
		System.out.println("2: Lord of the Flies - William Golding");
		System.out.println("3: One Hundred Years of Solitude - Gabriel García Márquez");
		System.out.println("Available commands: borrow, return, status");
		System.out.println("Example usage: borrow 1");
		System.out.println("==========================");
		System.out.print("Your command: ");
	}
	
	/**
	 * This method is used when the user is about to enter date
	 * to borrow the book. This prints out information about
	 * entering the date.
	 */
	public static void enterDate() {
		System.out.println("==========================");
		System.out.println("Until when? (Use MM/DD/YYYY syntax)");
		System.out.println("For example: 12/15/2020");
		System.out.println("==========================");
		System.out.print("Your date: ");
	}
	
	/**
	 * This method helps to get nth word from a String without using arrays.
	 * 
	 * @param input			The string from which the word should be get.
	 * @param userIndex		The index of the word (this starts from 1)
	 * @return				The requested word
	 */
	public static String getWord(String input, int userIndex) {
		int i;
		int index;
		String wordSoFar;
		
		wordSoFar = "";
		index = 0;
		// this is done so that the last word can be found without the need
		// of checking if i is reading the last char.
		input = input + " ";
		
		for ( i = 0; i < input.length(); i++ ) {
			
			if ( input.charAt(i) == ' ') {
				index = index + 1;
				if ( index == userIndex ) {
					return wordSoFar;
				} else {
					wordSoFar = "";
				}
			} else {
				wordSoFar = wordSoFar + input.charAt(i);
			}
		}
		return null;
	}
	
}
