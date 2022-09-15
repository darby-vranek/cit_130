/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing
/// this assignment.
/// @file darbyVranekcit130_Pa12.java
/// @version The date as 2022-04-26
/// @brief This program explores the use of exceptions and text files in Java
/// @note completed in around 5 hours

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;


public class darbyVranekcit130_Pa12 {
	public static Scanner input; // global scanner instance

	public static void main(String[] args) {
		input = new Scanner(System.in); // instantiate to collect user input
		boolean menuOpen = true; // track whether menu should continue to loop
		do {
			// display menu and get valid choice
			switch (menu()) {
				case 1: validateInt();
					break;
				case 2: validateDecimal();
					break;
				case 3: processArr();
					break;
				case 4: analyzeText();
					break;
				case 5: System.out.println("Goodbye!");
					// set menuOpen to false to stop while loop and end program
					menuOpen = false;
					break;
			}
		} while (menuOpen);
	}

	// menu - displays main menu and gets valid menu choice from user
	// @param none
	// @return choice (int) - will be a number between 1 and 5, corresponding to the user's menu choice
	public static int menu() {
		int choice = 0; // user's menu selection
		boolean acceptsInput = true; // tracks if program is still awaiting a valid menu choice
		do {
			System.out.println("\n=== Main Menu ===");
			System.out.println("Enter 1 to validate an integer");
			System.out.println("Enter 2 to validate a decimal number");
			System.out.println("Enter 3 to process an array");
			System.out.println("Enter 4 to process a file");
			System.out.println("Enter 5 to exit");
			choice = getInputInt(); // get int input from user
			// validate that choice is between 1 and 5, because there are 5 options
			if (choice > 0 && choice <= 5) {
				acceptsInput = false; // set to false to end loop
			}
		} while (acceptsInput);
		return choice;
	}


	// getInputInt - gets a valid integer input from the user using Scanner
	// @param none
	// @return number (int) - a validated integer input by the user
	public static int getInputInt() {
		int number = -5; // initialize int to hold user's input
		boolean acceptsInput = true; // track whether loop should continue to accept user input
		do { // loop until a valid integer is received from user
			try {
				number = input.nextInt();
				acceptsInput = false; // prevent while loop from repeating once a valid integer is accepted
			}
			catch (InputMismatchException ex) {
				System.out.println("*** Invalid entry - Try again");
				input.nextLine(); // clear input
			}
		} while (acceptsInput);
		return number;
	}

	// getInputDecimal - gets a validated decimal number between 1 and 100
	// @param none
	// @return number (float) - returns a validated decimal one the user inputs a valid number
	public static float getInputDecimal() {
		boolean acceptsInput = true; // track whether program should accept user input
		float number = -5f; // init value to hold user's input number
		do {
			try {
				number = input.nextFloat();
				// if valid decimal in range of 1 to 100, end loop and return value
				if (number >= 1 && number <= 100) {
					acceptsInput = false;
				}
			}
			catch (InputMismatchException ex) {
				System.out.println("*** Invalid entry - Try again");
				input.nextLine();
			}
		} while (acceptsInput);
		return number;

	}


	// validateInt - assigned method to check if a user has input an integer greater than -5
	// @param none
	// @return none
	public static void validateInt() {

		System.out.println("\n=== Validate an Integer ===");
		int inputInt = -5; // int to hold user's validated integer
		System.out.print("Enter an integer to test, more than -5: ");
		do {
			// get a valid integer from user
			inputInt = getInputInt();
			// determine if valid integer is greater than -5, the other condition
			if (inputInt <= -5) {
				System.out.println("***Invalid entry - Try again");
			}
		} while (inputInt <= -5); // continue loop until a valid integer is provided
		System.out.println("You entered a valid integer: " + inputInt);
	}

	// validateDecimal - assigned method to check if a decimal value is between 1 and 100
	// @param none
	// @return none
	public static void validateDecimal() {
		System.out.println("\n=== Validate a Decimal ===");
		System.out.print("Enter a decimal number: ");
		// get valid decimal input from user
		System.out.println("You entered a valid decimal number: " + getInputDecimal());
	}

	// processArr - assigned method to generate a random 10 integer array, display the results, and save to file
	// @param none
	// @return none
	public static void processArr() {
		int[] ints = new int[10]; // array for 10 randomly generated ints
		String[] intStrs = new String[10]; // string representation of random ints
		for (int i = 0; i < 10; i++) {
			ints[i] = 10 + (int)Math.ceil(Math.random() * 90);
			//get random value between 10 and 90, and save both int and string representation of value
			intStrs[i] = Integer.toString(ints[i]);
		}
		// join string representation for easy printing
		String intStr = String.join(" ", intStrs);
		System.out.println("\n=== Process an Array ===");
		System.out.println(intStr);
		boolean acceptsInput = true; // track if program should continue to loop for user input
		do {
			System.out.print("Enter an index of the array: ");
			int index = getInputInt(); // get integer from user
			try {
				System.out.println("The index " + index + " has " + ints[index] + " stored.");
				acceptsInput = false; // end looping once valid input is provided
			}
			catch (IndexOutOfBoundsException ex) { // this error will occur if an integer outside 0-9 is provided
				System.out.println("Error, invalid index was entered.");
				input.nextLine(); //clear input
			}
		} while (acceptsInput);

		System.out.print("Enter a filename to save array: ");
		String filename = input.next();

		writeData(filename, intStr);

	}


	// writeData - helper method to save specifically formatted string
	// @param filename(string) - the name of the file to save to, intStr (string) - the string representation of the 10 digit int array
	// @return none
	public static void writeData(String filename, String intStr) {
		File file = new File(filename); // create file of given name
		try {
			// attempt to write required lines to file
			PrintWriter output = new PrintWriter(file);
			output.println("Darby Vranek");
			output.println(intStr);
			output.close();
			System.out.println("Array saved!");
		}
		catch (IOException ex) {
			System.out.println("Invalid file!");
		}
	}


	// analyzeText - assigned method to count number of digits and vowels in provided text files
	//@param none
	//@return none
	public static void analyzeText() {
		final String filename = "testData.txt"; // hard-coded
		int vowelCount = 0; // track total vowels
		String vowels = "aeiou"; // reference for vowels
		int digitCount = 0; // track total digits
		String digits = "1234567890"; // digit reference
		int fileSize = 0; // size of file in bytes

		try {
			File file = new File(filename);
			fileSize = (int)file.length();
			Scanner text = new Scanner(file); // open scanner for file instead of for user input

			while (text.hasNextLine()) {
				String line = text.nextLine().toLowerCase();

				// check to see if each character in piece is either in the vowels or digits reference string
				for (int i = 0; i < line.length(); i++) {
					if (vowels.contains(line.substring(i, i+1))) {
						vowelCount++;
					} else if (digits.contains(line.substring(i, i+1))) {
						digitCount++;
					}
				}
			}

			System.out.println("\n=== Process a File ===");
			System.out.println("File: " + filename);
			System.out.println("Number of vowels: " + vowelCount);
			System.out.println("Number of digits: " + digitCount);
			System.out.println("The file has " + fileSize + " bytes");

		}
		catch (IOException ex) {
			System.out.println("File not found!");
		}
	}

}
