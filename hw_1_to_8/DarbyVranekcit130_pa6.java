/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing /// this assignment.
/// @file DarbyVranekcit130_pa6.java
/// @version The date as 2022-03-09
/// @brief Demonstrates understanding of Java user-defined methods based on
/// material covered in chapter 6 of the textbook
/// Loops through a main menu, prints a number pattern to console, counts
/// the number of incidences of a character in a string, and calculates
/// the future value of an investment
/// than one or two paragraphs)
/// @note took approximately 4 hours to complete

import java.util.Scanner;

public class DarbyVranekcit130_pa6 {
	public static Scanner input; // global input variable to be shared

	/// menu - displays a list of menu options
	/// @param - none
	/// @return - none
	public static void menu() {
		System.out.println("1. Display a pattern");
		System.out.println("2. Count number of characters");
		System.out.println("3. Calculate Future value of investment");
		System.out.println("4. End the program");
	}

	/// pattern - displays a number pattern and returns the value of
	/// the product of those numbers as a double
	/// @param nlines [int] user-input, indicates the number of rows and
	/// columns to be displayed
	/// @return: double of the product of all numbers calculated
	public static double pattern(int nlines) {
		String pattern_string; // holds the string representation of the generated pattern
		double product; // will be the return value, multiplied by each number in the
		                // number pattern

		/// initialize empty pattern string to build from there
		pattern_string = "";
		/// initialize with product = 1 because of product identity rule
		product = 1.0;
		/// this should run nlines times, following the given pattern, count down
		while (nlines > 0) {
			for (int i = nlines; i > 0; i--) {
				pattern_string = pattern_string + Integer.toString(i) + " ";
				product *= i;
			}
			pattern_string += "\n"; // moves onto the next pattern row
			nlines--; // reduces nlines so next row will be shorter
		}
		System.out.println(pattern_string);
		return product;
	}

	/// count - asks for input string and character to search for, then
	/// the number of times the character occurs in the string
	/// @param str [String] - user input string to find characters in
	/// @param c [char] - user input character to search for in input str
	/// @return: int, number of times c occurs in str
	public static int count(String str, char c) {
		int count; /// number of tiles c found in str

		count = 0;
		/// first check to see if c is actually in str, otherwise will return 0
		if (str.contains(Character.toString(c))) {
			/// loop through every letter in str to match with c
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == c) {
					count++; // increment count for every instance of c found
				}
			}
		}
		return count;
	}

	/// FutureValue - calculates the future value of an investment based on
	/// amount invested, yearly interest rate, and number of years invested
	/// @param - investedAmount [double] - the amount in dollars invested
	/// @param yearlyInterestRate [double] - the yearly interest rate in decimal (percentage / 100)
	/// @param numberOfYears [int] - the length of the investment in years
	public static double FutureValue(double investedAmount, double yearlyInterestRate, int numberOfYears) {
		double monthlyInterestRate; // monthly interest, based on yearly rate
		double futureValue; // the final calculated value based on interest, to be returned
		monthlyInterestRate = yearlyInterestRate/12;
		/// plug in investedAmount, monthlyInterestRate, and numberOfYears into formula
		futureValue = investedAmount * Math.pow(monthlyInterestRate+1,numberOfYears*12);
		return futureValue;
	}

	/// main - entry point for the appplication, handles the switch statement
	/// that opens the different defined methods
	/// @param args [String[]] used internally by program
	/// return - none
	public static void main(String[] args) {
		input = new Scanner(System.in);
		boolean isRunning; // will be set to false in order to stop menu loop

		isRunning = true; // start with menu open
		while (isRunning) {
			menu();
			switch (input.nextLine()) {
				case "1": {
					int lineCount;
					double product;
					System.out.print("Please enter the total number of lines you would like in the pattern: ");
					lineCount = Integer.parseInt(input.nextLine());
					product = pattern(lineCount);
					System.out.printf("The product of all those numbers is %.2f\n", product);
					break;
				}
				case "2": {
					String countStr;
					char countChar;
					int total;
					System.out.print("Enter a string: ");
					countStr = input.nextLine();
					System.out.print("Enter a character to consider: ");
					countChar = input.nextLine().charAt(0);
					total = count(countStr, countChar);
					System.out.println("The letter " + countChar + " was found in " + countStr + ": " + total + " time(s).\n");
					break;
				}
				case "3": {
					double investedAmount; // the amount of money the user will invest
					double yearlyInterestRate; // the decimal interest rate
					int numberOfYears; // how long the invested amount will earn interest
					double futureValue; // the final calculated value of the amount after added interest
					System.out.println("Enter investment amount");
					investedAmount = Double.parseDouble(input.nextLine());
					System.out.println("Enter yearly rate");
					yearlyInterestRate = Double.parseDouble(input.nextLine());
					yearlyInterestRate *= 0.01; // must be converted from percent to decimal
					System.out.println("Enter number of years to calculate the future value");
					numberOfYears = Integer.parseInt(input.nextLine());
					futureValue = FutureValue(investedAmount, yearlyInterestRate, numberOfYears);
					System.out.printf("After %d years at the interest rate of %.2f%%, Future value is: $%.2f\n", numberOfYears, yearlyInterestRate*100, futureValue);
					break;
				}
				case "4": {
					isRunning = false; // this will end the menu loop once this switch statement is done
					System.out.println("Thank you. Goodbye!");
					break;
				}
				default: {
					System.out.println("Invalid choice\n");
					break;
				}
			}
		}
	}
}
