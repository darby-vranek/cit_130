/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing
/// this assignment.
/// @file DarbyVranekcit130_pa3.java
/// @version 2022-02-08
/// @brief Calculates bank fees and body fat percentage.
/// @note Approximately 3 hours to complete

// enter 1 to run the fee program
	// prompt "Enter the number of checks: " {input}
		// if input <= 0:
			// error message
			// fee = -999
		// else
			// compute fee

// enter 2 to run the body fat program
	// prompt "Enter gender as M or F" {gender}
		// if gender != M or F
			// print "Gender Error"
		// else
			// if F
				// collect A1, A2, A3, A4, A5
			// else
				// collect A1, A2

// enter 3 to quit
	// print "Thanks for using my program"
	// quit program

// else
	// error message

import java.util.Scanner;

public class DarbyVranekcit130_pa3 {
	/// accepts user input to determine what to calculate
	/// case 1 calculates bank fees
	/// case 2 calculates body fat percentage
	/// case 3 closes the program
	/// @param = none
	/// @return = none
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // collects user input
		System.out.print("Enter 1 to run the fee program, enter 2 to run the body fat program, 3 to quit: ");
		switch (input.nextInt()) {
			// runs the fee program
			case 1: {
				int numChecks; // user input for number of checks deposited
				double rate; // amount user is charged per check
				double fee; // amount user pays per month
				System.out.print("Enter the number of checks: ");
				numChecks = input.nextInt();
				// cost per item varies based on the number of checks deposited
				if (numChecks > 0 && numChecks <= 20) {
					rate = 0.09;
				}
				else if (numChecks > 20 && numChecks <= 40) {
					rate = 0.07;
				}
				else if (numChecks > 40 && numChecks <= 60) {
					rate = 0.06;
				}
				else if (numChecks > 60) {
					rate = 0.05;
				}
				else {
					// numbers below or equal to 0 are invalid
					System.out.println("Invalid number of checks has been entered - no processing will be performed.");
					System.out.println("Fee = $-999");
					break;
				}
				/// calculate fee with base price of $8 plus the cost of checks
				fee = 8.0 + (numChecks * rate);
				System.out.println("Fee = $" + fee);
				break;
			}
			// calculates body fat based on formula
			case 2: {
				System.out.println("Enter gender as M or F");
				// switch statement based on input
				switch (input.next()) {
					case "M": {
						// collects measurements to calculate male body fat
						// formula:
						// A1 = (weight * 1.082) + 94.42
						// A2 = waist measurement * 4.15
						// B = A1 - A2
						// Body fat = weight - B
						// Body fat percentage = (body fat * 100)/weight
						double weight; // user input in pounds
						double waist; // user input in inches
						double a1; // formula: (weight * 1.082) + 94.42
						double a2; // formula: waist * 4.15
						double b; // formula: a1-a2
						double bodyFat; // formula: weight - b
						double bodyFatPercent; // (bodyFat * 100)/weight
						System.out.print("Enter weight: ");
						weight = input.nextDouble();
						System.out.print("Enter waist measurement: ");
						waist = input.nextDouble();
						// plug user values into formula
						a1 = (weight * 1.082) + 94.42;
						System.out.println("A1 = " + a1);
						a2 = waist * 4.15;
						System.out.println("A2 = " + a2);
						b = a1 - a2;
						System.out.println("B = " + b);
						bodyFat = weight - b;
						System.out.println("Body Fat = " + bodyFat);
						bodyFatPercent = (bodyFat * 100)/weight;
						System.out.println("Body Fat percentage = " + bodyFatPercent);
						break;
					}
					case "F": {
						// collects measurements to calculate female body fat
						// A1 = (weight * 0.732) + 8.987
						// A2 = wrist measurement / 3.14
						// A3 = waist measurement * 0.157
						// A4 = forearm measurement * 0.434
						// B = A1 + A2 - A3 - A4 + A5
						// Body fat = weight - b
						// Body fat percentage = Body fat * 100 / weight
						double weight; // user input (pounds)
						double waist; // user input (inches)
						double wrist; // user input (inches)
						double hip; // user input (inches)
						double forearm; // user input (inches)
						double a1; // formula: (weight * 0.732) + 8.987
						double a2; // formula: wrist / 3.14
						double a3; // formula: waist * 0.157
						double a4; // formula: hip * 0.249
						double a5; // formula: forearm * 0.434
						double b; // formula: a1 + a2 - a3 - a4 + a5
						double bodyFat; // formula: weight - b
						double bodyFatPercent; // formula: (bodyFat * 100)/weight
						System.out.print("Enter weight: ");
						weight = input.nextDouble();
						System.out.print("Enter waist measurement: ");
						waist = input.nextDouble();
						System.out.print("Enter wrist measurement: ");
						wrist = input.nextDouble();
						System.out.print("Enter hip measurement: ");
						hip = input.nextDouble();
						System.out.print("Enter forearm measurement: ");
						forearm = input.nextDouble();
						// apply formula
						a1 = (weight * .732) + 8.987;
						a2 = wrist / 3.14;
						a3 = waist * 0.157;
						a4 = hip * 0.249;
						a5 = forearm * 0.434;
						b = a1 + a2 - a3 - a4 + a5;
						bodyFat = weight - b;
						bodyFatPercent = (bodyFat * 100) / weight;
						// display values
						System.out.println("A1 = " + a1);
						System.out.println("A2 = " + a2);
						System.out.println("A3 = " + a3);
						System.out.println("A4 = " + a4);
						System.out.println("A5 = " + a5);
						System.out.println("B = " + b);
						System.out.println("Body fat = " + bodyFat);
						System.out.println("Body Fat percentage = " + bodyFatPercent);
						break;
					}
					default: {
						// if input is not "M" or "F", error
						System.out.println("Gender Error");
						break;
					}
				}
				break;
			}
			// ends program
			case 3: {
				System.out.println("Thanks for using my program");
				return;
			}
			default: System.out.println("Invalid input."); break;
		}
		// repeats program until you quit
		main(args);
	}
}
