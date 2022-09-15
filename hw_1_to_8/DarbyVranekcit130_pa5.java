/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing
/// this assignment.
/// @file DarbyVranekcit130_pa5.java
/// @version 2022-22-22
/// @brief loops around a main menu to open a program to calculate
/// and display miles traveled in a period of time, and one that determines
/// if integer inputs are even or odd, and then displays the sums and averages
/// of even, odd, and all inputs
/// @note Took approximately 3 hours to write and test

/* pseudocode problem - menu
	1. start
	2. input choice
			while choice != 0:
			1. if choice == 1, calculate distance
			2. if choice == 2, process integers
			3. if choice == 0, end program
			4. else input choice
	3. end
*/

/* pseudocode problem - calculate distance traveled
	1. start
	2. input speed
		a. if speed < 1 or speed > 120, output error, collect input again
	3. input hours
		a. if hours < 0, output error, collect input again
	4. output distance traveled
		for (int i = 1; i < hours; i++)
			1. output i * speed
	5. end
*/

/* pseudocode problem - process integers
	1. start
		while input != -99
			1. input input_int
			2. calculate is_even -> input_int%2 == 0
				if is_even, output Even
				else output Odd
*/


import java.util.Scanner;

public class DarbyVranekcit130_pa5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice; // menu input
		int speed; // miles per hour; 0 < speed < 121
		int hours; // time car spent traveling; hours > 0
		int int_choice; // user inputs for integers to be processed
		int even_ints; // sum of all even inputted ints
		int even_count; // number of even inputs
		int odd_ints; // sum of all odd inputted ints
		int odd_count; // number of odd inputs
		double even_average; // (even_ints/even_count)
		double odd_average; // (odd_ints/odd_count)
		double all_average; // (odd_ints + even_ints)/(odd_count + even_count)

		// display options menu
		System.out.println("Options Menu:");
		System.out.println("enter 1 to process car travel data");
		System.out.println("enter 2 to process a set of integers");
		System.out.println("enter 0 to end the program");

		// main menu choice must be 0, 1, or 2
		choice = input.nextInt();
		while (choice != 0) {
			// menu 1 opens car distance calculator
			if (choice == 1) {
				System.out.println("Car Travel Data");
				System.out.println("How fast is the car going? (must be between 1mph and 120mph)");
				speed = input.nextInt();
				// check to make sure speed is between 1 and 120mph
				while (speed < 1 || speed > 120) {
					System.out.println("Speed must be between 1mph and 120mph:");
					speed = input.nextInt();
				}
				System.out.println("How many hours is it traveling?");
				hours = input.nextInt();
				// check to make sure that hours are positive
				while (hours < 1) {
					System.out.println("How many hours is it traveling? Cannot be a negative number");
					hours = input.nextInt();
				}
				System.out.println("Hour:  Distance:");
				for (int i = 1; i <= hours; i++) {
					double total = speed*i;
					System.out.println(i + "      " + total + " miles");
				}
				choice = 0;
			} else if (choice == 2) {
				// main menu input 2, load int processor
				even_ints = 0;
				even_count = 0;
				odd_ints = 0;
				odd_count = 0;
				System.out.println("Process a set of Integers");
				// identify sentinel value
				System.out.println("To end the calculation, enter -99");
				System.out.println("Please enter an integer");
				int_choice = input.nextInt();
				if (int_choice == -99) {
					// if list starts with sentinel, display error and end
					System.out.println("There is no data to process");
					choice = 0;
				}
				while (int_choice != -99) {
					// determine if number is even by calculating remainder
					if (int_choice % 2 == 0) {
						System.out.println("Even");
						even_ints += int_choice;
						even_count++;
					} else {
						System.out.println("Odd");
						odd_ints += int_choice;
						odd_count++;
					}
					System.out.println("Please enter an integer");
					int_choice = input.nextInt();
				}
				// check even_count to avoid dividing by 0
				if (even_count != 0) {
					even_average = even_ints / even_count;
				} else {
					even_average = 0;
				}
				// check odd_count to avoid dividing by 0
				if (odd_count != 0) {
					odd_average = odd_ints / odd_count;
				} else {
					odd_average = 0;
				}
				// check both sums to make sure all_average doesn't divide by 0
				if (even_count + odd_count != 0 && even_average + odd_average != 0) {
					all_average = (even_ints + odd_ints) / (even_count + odd_count);
					System.out.printf("Sum of Even values = %4.2f\n", (double)even_ints);
					System.out.printf("Sum of Odd values = %4.2f\n", (double)odd_ints);
					System.out.printf("Average of Even values = %4.2f\n", (double)even_average);
					System.out.printf("Average of Odd values = %4.2f\n", (double)odd_average);
					System.out.printf("Average of All values = %4.2f\n", (double)all_average);
				} else {
					all_average = 0;
				}
				// quits the program next iteration
				choice = 0;
			} else {
				// loop to get a correct input
				System.out.println("Invalid choice - try again");
				choice = input.nextInt();
			}
		}
	}
}
