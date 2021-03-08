import java.util.ArrayList;

/**
 * This class is a simple library that contains
 * books as LibraryBook Object. 
 * 
 * Has simple methods to add, remove or return a specific book.
 * 
 * @author Tolga Ozgun
 * @version 1.0, 12/22/2020
 *
 */

public class Library {
	
	private ArrayList<LibraryBook> bookList = new ArrayList<>();
	
	/**
	 * Checks if the library is empty and returns a boolean.
	 * 
	 * @return		boolean if the library is empty.
	 */
	public boolean isEmpty() {
		return bookList.isEmpty();
	}

	/**
	 * This method overrides Java's default toString() method
	 * by returning a String with titles and authors 
	 * of each books in each line.
	 * 
	 * @return 		Book titles and authors
	 */
	@Override
	public String toString() {
		String message;
		
		if ( isEmpty() ) {
			message = "Library is empty.";
		} else {
			message = "";
			for( LibraryBook book: bookList) {
				message += book.getTitle() + " by " + book.getAuthor() + "\n";
			}
		}
		message = message.trim();
		return message;
	}
	
	/**
	 * This method creates a book with given title 
	 * and author. Then adds the book to the library.
	 * 
	 * @param title			Title of the book
	 * @param author		Author of the book
	 */
	public void add(String title, String author) {
		LibraryBook book;
		
		book = new LibraryBook(title, author);
		bookList.add(book);
	}
	
	/**
	 * This method removes the specified book from
	 * the library if exists. Returns a boolean value
	 * whether the book existed or not.
	 * 
	 * @param book			Book to be removed.
	 * @return				If the book exists.
	 */
	public boolean remove(LibraryBook book) {
		if ( bookList.contains(book) ) {
			bookList.remove(book);
			return true;
		}
		return false;
	}
	
	/**
	 * This method finds the book with the specified title
	 * and returns it.
	 * 
	 * @param title			Title of the book.
	 * @return				The LibraryBook object of the book.
	 */
	public LibraryBook findByTitle(String title) {
		for ( LibraryBook book: bookList ) {
			if ( book.getTitle().equals(title) ) {
				return book;
			}
		}
		return null;
	}
	
}
