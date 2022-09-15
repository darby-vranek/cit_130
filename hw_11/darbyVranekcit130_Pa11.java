/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing
/// this assignment.
/// @file darbyVranekcit130_Pa11.java
/// @version The date as 2022-04-19
/// @brief This is a program to practice the use of ArrayLists in Java
/// @note completed in around 2 hours

import java.util.Scanner;
import java.util.ArrayList;

public class darbyVranekcit130_Pa11 {

	public static void main(String[] args) {
		final int unitCost = 20; // define named constant for unit cost of all items

		Scanner input = new Scanner(System.in); // initialize scanner to accept user input

		// initialize ArrayLists to hold user purchase data
		ArrayList<String> users = new ArrayList<>(); // names of customers
		ArrayList<Integer> orderCounts = new ArrayList<>(); // number of purchases made by each customer
		ArrayList<Integer> orderCosts = new ArrayList<>(); // total cost for each purchase

		boolean needsValidPurchaseCount = true;
		int purchaseCount = 0; // initialize total number of purchases to account for invalid inputs

		// prompt user to enter number of purchases made at business
		System.out.print("Enter the number of purchases: ");
		// continuous loop until valid number between 1 and 10 is input
		while (needsValidPurchaseCount) {
			purchaseCount = Integer.parseInt(input.nextLine()); // user input
			// validate that number of purchases is between 1 and 10
			if (purchaseCount > 0 && purchaseCount <= 10) {
				// accept input for the specified number of purchases
				for (int i = 0; i < purchaseCount; i++) {
					System.out.print("Enter the person's full name: ");
					String fullName = input.nextLine(); // user input
					System.out.print("Enter the number of items purchased: ");
					int orderCount = Integer.parseInt(input.nextLine()); // user input
					// add purchase data to ArrayLists
					users.add(fullName);
					orderCounts.add(orderCount);
					orderCosts.add(orderCount * unitCost); // calculate total order cost
				}
				// set false to stop while loop once valid input is received
				needsValidPurchaseCount = false;
			}
			else {
				// display error message if an invalid count is input, then execute next loop
				System.out.print("Invalid entry - try again: ");
			}
		}

		System.out.println("PURCHASE REPORT");
		// display the data using the toString method for each arraylist
		System.out.println(users);
		System.out.println(orderCounts);
		System.out.println(orderCosts);

		boolean needsUser = true; // initialize boolean to track whether the program expects more input
		// begin continuous loop until "exit" input received
		while (needsUser) {
			System.out.print("Who would you like to search for? Enter exit to end search: ");
			String userSearch = input.nextLine(); // user input
			// check if sentinel value "exit" has been input, if so end loop
			if (userSearch.equals("exit")) {
				needsUser = false;
			}
			else {
				boolean foundUser = false; // keep track through loops whether a user matching that search has been found
				for (int i = 0; i < users.size(); i++) {
					// case insensitive check to see if search string is in user list
					if (users.get(i).equalsIgnoreCase(userSearch)) {
						// prevent while loop from running to collect another user after a match has already been found
						foundUser = true;
						System.out.printf("%s found\n", userSearch);
						System.out.printf("%s %s %s\n", orderCounts.get(i), unitCost, orderCosts.get(i));
					}
				}
				if (!foundUser) {
					// display error message and repeat loop if nothing found
					System.out.printf("%s NOT found\n", userSearch);
				}
			}
		}

		// prompt user for number of data to add and allow user to add more names
		System.out.print("Enter the number of data to add: ");
		int dataCount = Integer.parseInt(input.nextLine()); // user input

		for (int i = 0; i < dataCount; i++) {
			System.out.print("Enter the person's full name: ");
			String newUser = input.nextLine(); // user input
			System.out.print("Enter the number of items purchased: ");
			int itemNumber = Integer.parseInt(input.nextLine()); // user input
			// add data to appropriate arraylists
			users.add(newUser);
			orderCounts.add(itemNumber);
			orderCosts.add(itemNumber * unitCost);
		}

		// ask user for the name of a person to remove and remove data from lists
		boolean addingData = true;
		// begin continuous loop until valid user to remove from list is found
		while (addingData) {
			System.out.print("Who would you like to remove? ");
			String toRemove = input.nextLine(); // user input

			if (users.contains(toRemove)) {
				// find index and remove user data from all three arraylists
				int index = users.indexOf(toRemove);
				users.remove(index);
				orderCounts.remove(index);
				orderCosts.remove(index);
				addingData = false; // set to false to end continuous loop once a user has been removed
			}
			else {
				// display error message if user is not found and repeat loop
				System.out.printf("%s NOT found\n", toRemove);
			}
		}

		System.out.println("FINAL PURCHASE REPORT");
		System.out.printf("The size of the array list is: %s\n", users.size());

		// format and display each record
		for (int i = 0; i < users.size(); i++) {
				System.out.printf("Name: %s | Number of items: %s | Total cost: $%s\n", users.get(i), orderCounts.get(i), orderCosts.get(i));
		}
	}
}
