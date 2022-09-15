/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing /// this assignment.
/// @file DarbyVranekcit130_pa8.java
/// @version The date as 2022-03-22
/// @brief This program demonstrates the functionality of a class called
/// Company by displaying how values can be assigned either by passing them
/// through a setter function or by directly setting them using dot notation
/// with console output styled to resemble the original Java code
/// @note Took under 2 hours to complete

import java.util.Scanner;

public class DarbyVranekcit130_pa8 {
	public static Scanner input; // global input variable to be shared

	/// program entrance point
	public static void main(String[] args) {
		public Company company; // company to be created
		public String name; // input for Company.companyName
		public String url; // input for Company.companywebAddress
		public String country; // input for Company.companyCountry
		public int employeeCount; // input for Company.companyNumberEmployees
		input = new Scanner(System.in); // initialize scanner

		System.out.println("=== Company class demonstration ===");
		// first create new company with default values and display
		System.out.println("1. Create new Company object with default attributes");
		company = new Company(); // initialize new company with default values set by constructor
		System.out.println("> company = new Company()");
		System.out.println("> company.displayValues()");
		company.displayValues();

		// accept user input to pass to Compamy.setValues, then display
		System.out.println("2. Input values to pass to company.setValues");
		System.out.print("> String name = ");
		name = input.nextLine();
		System.out.print("> String url = ");
		url = input.nextLine();
		System.out.print("> String country = ");
		country = input.nextLine();
		System.out.print("> int employeeCount = ");
		employeeCount = Integer.parseInt(input.nextLine());

		System.out.println("> company.setValues(name, url, country, employeeCount)");
		company.setValues(name, url, country, employeeCount);
		System.out.println("> company.displayValues()");
		company.displayValues();

		// accept input for each attribute individually, then display
		System.out.println("3. Directly assign values using dot operator");
		System.out.print("> company.companyName = ");
		company.companyName = input.nextLine();
		System.out.print("> company.companywebAddress = ");
		company.companywebAddress = input.nextLine();
		System.out.print("> company.companyCountry = ");
		company.companyCountry = input.nextLine();
		System.out.print("> company.companyNumberEmployees = ");
		company.companyNumberEmployees = Integer.parseInt(input.nextLine());
		System.out.println("> company.displayValues()");
		company.displayValues();
	}
}

class Company {
	 public String companyName; // display name of company
	 public String companywebAddress; // url for company webpage
	 public String companyCountry; // company's country of origin
	 public int companyNumberEmployees; // total number of employees

	 public Company() {
		 // assign default values when creating a new Company instance
		 companyName = "CSN";
		 companywebAddress = "http://www.csn.edu";
		 companyCountry = "USA";
		 companyNumberEmployees = 1000;
	 }

	 /// setValues - public setter function allowing assignment of all values at once
	 /// @param name (String) - user input, display name of company
	 /// @param url (String) - user input, company web address
	 /// @param country (String) - user input, company's country of operation
	 /// @param employeeCount - user input, number of employees at company
	 /// @return - none
	 public void setValues(String name, String url, String country, int employeeCount) {
		 this.companyName = name;
		 this.companywebAddress = url;
		 this.companyCountry = country;
		 this.companyNumberEmployees = employeeCount;
	 }

	 /// displayValues - prints all assigned values to console
	 /// @return - none
	 public void displayValues() {
		 System.out.println("\n    Name: " + companyName);
		 System.out.println("    Web Address: " + companywebAddress);
		 System.out.println("    Country: " + companyCountry);
		 System.out.println("    Number of Employees: " + companyNumberEmployees + "\n");
	 }
}
