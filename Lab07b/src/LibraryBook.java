import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.2, 12/15/2020
 * 
 * This class is for LibraryBook objects which have attributes such as
 * title, author, the loan's due date and how many times it has been
 * loaned. It also contains methods for loaning and returning the book.
 *
 */

public class LibraryBook {
	
	private String title;
	private String author;
	private Date dueDate;
	private int timesLoaned;
	private final int DEFAULT_LOAN_LENGTH_IN_DAYS = 7;
	

	public LibraryBook(String title, String author) {
		this.title = title;
		this.author = author;
		this.dueDate = null;
		this.timesLoaned = 0;
	}
	
	public LibraryBook(String title, String author, Date dueDate) {
		this.title = title;
		this.author = author;
		this.dueDate = dueDate;
		this.timesLoaned = 0;
	}
	
	public LibraryBook(String title, String author, int timesLoaned) {
		this.title = title;
		this.author = author;
		this.dueDate = null;
		this.timesLoaned = timesLoaned;
	}
	
	public LibraryBook(String title, String author, Date dueDate, int timesLoaned) {
		this.title = title;
		this.author = author;
		this.dueDate = dueDate;
		this.timesLoaned = timesLoaned;
	}
	
	/**
	 * If no date is assigned, this method will call loanBook() method
	 * with a date specific days from now.
	 */
	public void loanBook() {
		Calendar calendar;
		Date dueDate;
		
		calendar = Calendar.getInstance();
		
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, DEFAULT_LOAN_LENGTH_IN_DAYS);
		dueDate = calendar.getTime();
		
		loanBook(dueDate);
	}
	
	/**
	 * This method checks if the due date of a loan is passed.
	 * 
	 * @return	boolean if the time passed.
	 */
	public boolean isTimePassed() {
		if ( dueDate != null && dueDate.before(new Date()) ) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method is for loaning a book. It sets the book as
	 * loaned by setting dueDate to a specified date. It also
	 * increases the amount of times a book has been loaned.
	 * 
	 * @param date		The date until which the book should stay loaned.
	 */
	public void loanBook(Date date) {
		dueDate = date;
		timesLoaned = timesLoaned + 1;
	}
	
	/**
	 * This method is for returning a book. 
	 * 
	 * It sets the book as returned by setting the dueDate null. 
	 */
	public void returnBook() {
		dueDate = null;
	}
	
	/**
	 * This method checks if the book is currently loaned.
	 * 
	 * @return		Is the book loaned
	 */
	public boolean onLoan() {
		return dueDate != null;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getTimesLoaned() {
		return timesLoaned;
	}

	public void setTimesLoaned(int timesLoaned) {
		this.timesLoaned = timesLoaned;
	}
	
	

}
