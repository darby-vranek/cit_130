/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing
/// this assignment.
/// @file darbyVranekcit130_Pa12.java
/// @version The date as 2022-04-19
/// @brief This is a program to practice the use of ArrayLists in Java
/// @note completed in around 2 hours

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;


public class darbyVranekcit130_Pa12 {
	public static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);

		boolean menuOpen = true;
		do {
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
					menuOpen = false;
					break;
			}
		} while (menuOpen);

	}


	public static int menu() {

		int choice = 0;
		boolean acceptsInput = true;

		do {
			System.out.println("Enter 1 to validate an integer");
			System.out.println("Enter 2 to validate a decimal number");
			System.out.println("Enter 3 to process an array");
			System.out.println("Enter 4 to process a file");
			System.out.println("Enter 5 to exit");

			choice = getInputInt();

			if (choice > 0 && choice <= 5) {
				acceptsInput = false;
			}
		} while (acceptsInput);

		return choice;

	}


	public static int getInputInt() {

		int number = -5;
		boolean acceptsInput = true;

		do {
			try {
				number = input.nextInt();
				acceptsInput = false;
			}
			catch (InputMismatchException ex) {
				System.out.println("*** Invalid entry - Try again");
				input.nextLine();
			}
		} while (acceptsInput);

		return number;

	}


	public static float getInputDecimal() {

		boolean acceptsInput = true;
		float number = -5f;

		do {
			try {
				number = input.nextFloat();
				acceptsInput = false;
			}
			catch (InputMismatchException ex) {
				System.out.println("*** Invalid entry - Try again");
				input.nextLine();
			}
		} while (acceptsInput);

		return number;

	}


	public static void validateInt() {

		int inputInt = -5;
		System.out.print("Enter an integer to test, more than -5: ");

		do {
			inputInt = getInputInt();
			if (inputInt <= -5) {
				System.out.println("***Invalid entry - Try again");
			}
		} while (inputInt <= -5);

		System.out.println("You entered a valid integer: " + inputInt);

	}


	public static void validateDecimal() {

		System.out.print("Enter a decimal number: ");
		System.out.println("You entered a valid decimal number: " + getInputDecimal());

	}


	public static void processArr() {

		int[] ints = new int[10];
		String[] intStrs = new String[10];
		for (int i = 0; i < 10; i++) {
			ints[i] = 10 + (int)Math.ceil(Math.random() * 90);
			intStrs[i] = Integer.toString(ints[i]);
		}
		String intStr = String.join(" ", intStrs);
		System.out.println("Array data: ");
		System.out.println(intStr);

		boolean acceptsInput = true;
		do {
			System.out.print("Enter an index of the array: ");
			int index = getInputInt();
			try {
				System.out.println("The index " + index + " has " + ints[index] + " stored.");
				acceptsInput = false;
			}
			catch (IndexOutOfBoundsException ex) {
				System.out.println("Error, invalid index was entered.");
				input.nextLine();
			}
		} while (acceptsInput);

		System.out.print("Enter a filename to save array: ");
		String filename = input.next();

		writeData(filename, intStr);

	}


	public static void writeData(String filename, String intStr) {
		File file = new File(filename);
		try {
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


	public static void analyzeText() {
		final String filename = "testData.txt";
		int vowelCount = 0;
		String vowels = "aeiou";
		int digitCount = 0;
		String digits = "1234567890";
		int fileSize = 0;

		try {
			File file = new File(filename);
			fileSize = (int)file.length();
			Scanner text = new Scanner(file);

			while (text.hasNextLine()) {
				String line = text.nextLine().toLowerCase();

				for (int i = 0; i < line.length(); i++) {
					if (vowels.contains(line.substring(i, i+1))) {
						vowelCount++;
					} else if (digits.contains(line.substring(i, i+1))) {
						digitCount++;
					}
				}
			}

			System.out.println("Number of vowels: " + vowelCount);
			System.out.println("Number of digits: " + digitCount);
			System.out.println("The file has " + fileSize + " bytes");

		}
		catch (IOException ex) {
			System.out.println("File not found!");
		}
	}

}
