import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.1, 12/22/2020
 *
 *
 * This program simulates a library of books. 
 * With this program, you can add, remove and see the status of books.
 * And for each book, you can loan and return, and see the status of it.
 * 
 */

public class LibraryTest {

	public static void main (String[] args) throws ParseException{
		Scanner scan = new Scanner(System.in);
		Library library;
		LibraryBook book;
		String userInput;
		String command;
		String commandString;
		String bookTitle;
		String bookAuthor;

		library = new Library();
		command = "";
		
		// Step 1: Loop the program until user enters 'exit'
		while (!command.equals("exit")) {
			// Step 2: Print help and get user input.
			printHelp();
			userInput = scan.nextLine();
			// Step 2.1: Get the command from the input.
			commandString = getWord(userInput, 1);
			command = commandString.toLowerCase();
			
			// Step 3: Compare the command String with existing commands.
			if (command.equals("show")) {
				// Step 3.1: Print the library if the command is show.
				System.out.println(library);
				
			} else if (command.equals("find")) {
				// Step 3.2.1: If the command is find, try to get the remaining words
				// from the user input. Set the book title to be those words and 
				// find the corresponding book with the title.
				bookTitle = userInput.replaceAll(commandString, "").trim();
				book = library.findByTitle(bookTitle);
				
				if (book == null) {
					// Step 3.2.2: If the book does not exist, print an error message.
					System.out.println("Book not found!");
				} else {
					// Step 3.2.3: If the book exists, print the book menu.
					manageBook(book);
				}
			} else if ( command.equals("add") ) {
				// Step 3.3.1: If the command is add, try to get the remaining words
				// from the user input. Set the book title to be those words and 
				// find the corresponding book with the title.
				bookTitle = userInput.replaceAll(commandString, "").trim();
				// Step 3.3.2: Get the author of the book from the user.
				System.out.println("=====================");
				System.out.println("Enter the author of " + bookTitle);
				System.out.println("=====================");
				bookAuthor = scan.nextLine();
				// Step 3.3.3: Add the book to the library.
				library.add(bookTitle, bookAuthor);
				// Step 3.3.4: Tell the user the book with corresponding title and author
				// is added successfully.
				System.out.println("Added " + bookTitle + " by " + bookAuthor + " successfully!");
			} else if ( command.equals("remove") ) {
				// Step 3.3.1: If the command is add, try to get the remaining words
				// from the user input. Set the book title to be those words and 
				// find the corresponding book with the title.
				bookTitle = userInput.replaceAll(commandString, "").trim();
				book = library.findByTitle(bookTitle);
				library.remove(book);
				System.out.println("Book " + book.getTitle() + " by " + book.getAuthor() + " removed successfully!");
			}
		}
		scan.close();
	}

	public static void manageBook(LibraryBook userBook) throws ParseException {
		Scanner scan = new Scanner(System.in);
		String userInput;
		String userCommand;
		String userDate;
		Date date;

		// Step 1: Print the help menu.
		printBookHelp(userBook);
		
		// Step 2: Get user input and command.
		userInput = scan.nextLine();
		userCommand = getWord(userInput, 1);
		
		// Step 3: Compare the command String provided by user with existing commands.

		if ( userCommand.equalsIgnoreCase("borrow") ) {
			// Step 3.1.1: Check if the book is already loaned, print an error message if true.
			if (userBook.onLoan()) {
				System.out.println(userBook.getTitle() + " is already borrowed! Come back later.");
			} else {
				// Step 3.2.2: If the book is not already loaned,
				// print a help message about the date entry.
				enterDate();
				
				// Step 3.2.3: Get the date provided by user and
				// set the book to be loaned until that date.
				userDate = scan.nextLine();
				date = new SimpleDateFormat("MM/dd/yyyy").parse(userDate);
				userBook.loanBook(date);
			}
		} else if (userCommand.equalsIgnoreCase("return")) {
			// Step 3.3.1: Check if the book is already loaned, if not
			// print an error message.
			if (!userBook.onLoan()) {
				System.out.println(userBook.getTitle() + " is not borrowed!");
			} else {
				// Step 3.3.2: If the book is loaned, return the book
				// and print a thank you message.
				userBook.returnBook();
				System.out.println("Thanks for returning " + userBook.getTitle());
			}
		} else if (userCommand.equalsIgnoreCase("status")) {
			// Step 3.4: If the command is status,
			// bypass this if-else statement.
			//
			// Each loop will print the book's info anyway.
			// This part exists so that command status does not enter the
			// else part where it says unknown command.
		} else {
			// Step 3.5: If the command is not one of the above,
			// it is invalid. Tell the user it is invalid.
			System.out.println("Unknown command.");
		}

		// Step 4: Print information about the specified book.
		printBookStatus(userBook);
		userBook = null;


	}

	/**
	 * This method prints the commands.
	 * This is used as a help menu.
	 */
	public static void printHelp() {
		System.out.println("=====================");
		System.out.println("Available Commands:");
		System.out.println("Show                     > Displays all books");
		System.out.println("Find  <Title>            > Manages a book");
		System.out.println("Add   <Title>            > Adds a book to the library");
		System.out.println("Exit                     > Exits the program");
		System.out.println("Example: Find The Catcher in The Rye");
		System.out.println("=====================");
	}

	/**
	 * This method prints help for the Book Menu.
	 * @param book			The book for which the menu should be displayed.
	 * 
	 */
	public static void printBookHelp(LibraryBook book) {
		System.out.println("=====================");
		printBookStatus(book);
		System.out.println("Available commands: borrow, return, status");
		System.out.println("=====================");
	}

	/**
	 * 
	 * This method displays information about the specified book. This information
	 * includes: title - The title of the book author - The author of the book is
	 * loaned - Check if the book is currently loaned is time passed - Check if the
	 * book's due date is passed. times loaned - How many times has this book been
	 * loaned before.
	 * 
	 * @param book The book of which the info will be displayed.
	 */
	public static void printBookStatus(LibraryBook book) {
		System.out.println("Book Title: " + book.getTitle());
		System.out.println("Book Author: " + book.getAuthor());
		System.out.println("Is Book Loaned: " + book.onLoan());
		System.out.println("Is Loan Time Passed: " + book.isTimePassed());
		System.out.println("Book Times Loaned: " + book.getTimesLoaned());
	}

	/**
	 * This method is used when the user is about to enter date to borrow the book.
	 * This prints out information about entering the date.
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
