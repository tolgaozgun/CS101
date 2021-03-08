import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Tolga Ozgun
 * @version 1.0, 12/22/2020
 *
 * This program takes a file with words and counts 
 * each word's length up to 
 */

public class LabEightC {
	
	public static void main(String[] args) throws IOException {
		String currentWord;
		int currentLength;
		int currentCount;
		int longestLength;
		ArrayList<Integer> wordLength;
		Scanner scan = new Scanner(new File("words.txt"));
		
		wordLength = new ArrayList<Integer>();
		longestLength = 0;
		
		// Step 1: We will assume the longest word will have 100 letters
		// at maximum. Each index in ArrayList will be the count of letters
		// in a word.
		//
		// We will increment the count, corresponding to the words'
		// read length.
		for ( int i = 0; i < 100; i++ ) {
			wordLength.add(0);
		}
		
		// Step 2: For each word in the file.
		while ( scan.hasNext() ) {
			// Step 2.1: Get the word.
			currentWord = scan.next();
			// Step 2.2: Get the current word's length.
			currentLength = currentWord.length();
			// Step 2.3: Increment the value in ArrayList 
			// corresponding to the word's length.
			currentCount = wordLength.get(currentLength);
			wordLength.set(currentLength, currentCount + 1);
		}
		
		// Step 3: With the index value from 0 to 11 inclusive,
		for ( int i = 0; i < 11; i++ ) {
			// Step 3.1: Get the corresponding count in the ArrayList.
			currentCount = wordLength.get(i);
			// Step 3.2: If the count is not equal to 0, set the longest length
			// to current length.
			if ( currentCount != 0 ) {
				longestLength = i;
				// Step 3.3: Print the user the amount of words with the current length.
				System.out.print(currentCount + " words with length " + i);
				if ( i == 10 ) {
					System.out.println();
				} else {
					System.out.print(", ");
				}
			}
		}
		// Step 4: Print the longest word's length.
		System.out.println("Longest word has the length " + longestLength);
	}

}
