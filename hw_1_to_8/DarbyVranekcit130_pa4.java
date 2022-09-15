/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing
/// this assignment.
/// @file DarbyVranekcit130_pa4.java
/// @version 2022-02-15
/// @brief A program to process shipping orders. Access restricted by password.
/// @note Took around 3 hours


import java.util.Scanner;

public class DarbyVranekcit130_pa4 {
	public static void main(String[] args) {
		// initializing values in case isValid == false at any point
		String password; // input password, should be "SeeM$"
		String name = ""; // input name, if longer than 5 letters -> "TOO LONG"
		String email = ""; // input email, if no @ -> "UNKNOWN.edu"
		String destination = ""; // package destination, USA and Canada are only options
		double orderAmount = 0;
		double shippingCost = 0;
		boolean isValid = true; // determines whether program can continue

		Scanner input = new Scanner(System.in); // initialize scanner

		// get password
		System.out.print("Enter your password: ");
		password = input.nextLine();
		if (!password.equals("SeeM$")) {
			System.out.println("Incorrect password – program terminates");
			isValid = false; // prevents program from processing anything else
		}
		// get name and email, skip if invalid password
		if (isValid) {
			System.out.print("Enter your name: ");
			name = input.nextLine();
			if (name.length() > 5) {
				name = "TOO LONG";
			}
			System.out.print("Enter your email address: ");
			email = input.nextLine();
			if (!email.contains("@")) {
				email = "UNKNOWN@edu";
			}
		}
		// get amount spent if valid, else skip
		if (isValid) {
			System.out.print("Enter the amount of your order: ");
			orderAmount = Double.parseDouble(input.nextLine());
			if (orderAmount <= 0) {
				System.out.println("Incorrect amount of order - program terminates");
				isValid = false; // stops program from processing below
			}
		}
		// get destination - must be USA or Canada (case insensitive)
		if (isValid) {
			System.out.print("Enter the destination: ");
			destination = input.nextLine();
			// separate if blocks to account for price differences between USA and Canada
			if (destination.equalsIgnoreCase("usa")) {
				if (orderAmount <= 50) {
					shippingCost = 6;
				} else if (orderAmount <= 100) {
					shippingCost = 9;
				} else if (orderAmount <= 150) {
					shippingCost = 12;
				} else {
					shippingCost = 0;
				}
			} else if (destination.equalsIgnoreCase("canada")) {
				if (orderAmount <= 50) {
					shippingCost = 8;
				} else if (orderAmount <= 100) {
					shippingCost = 12;
				} else if (orderAmount <= 150) {
					shippingCost = 15;
				} else {
					shippingCost = 0;
				}
			} else {
				System.out.println("Incorrect destination – program terminates");
				isValid = false;
			}
			// prints out full results only if all inputs are valid
			if (isValid) {
				System.out.println("\nSHIPPING REPORT");
				System.out.println("Password: " + password);
				System.out.println("Name: " + name);
				System.out.println("Email address: " + email);
				System.out.printf("Total amount of order: $%4.2f\n", orderAmount);
				System.out.println("Shipping destination: " + destination);
				System.out.printf("Shipping Cost: $%4.2f\n", shippingCost);
			}
		}

	}
}
