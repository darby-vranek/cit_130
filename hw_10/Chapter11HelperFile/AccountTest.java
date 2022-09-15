/* AccountTest.java:  - CIT130: Java Programming */
/*
 * Author:
 * Due Date:
 * Time taken to complete exercie
 */

/*Program Purpose
 * **********
 * Main Method: Uses Account class, checkingAccount subclass, and SavingsAccoutn subclass to create objects, then uses
 * the classes methods to get and set data for the objects.
 * INPUT VARIABLES:
 * deposit, withdraw
 * *****************
 */
import java.util.Scanner; //imports

public class AccountTest {
 public static void main(String[] args) {

  Scanner input = new Scanner(System. in ); //declare variable to accept input

  Account Account1 = new Account(); //creates new Account object called Account 1
  //Uses methods from Account class to set data values for Account 1
  Account1.setId(7);
  Account1.setBalance(5000);
  Account1.setAnnualInterestRate(2.4);
  AccountData(1, Account1); //Display Account 1 data using AccountData method

  Account Account2 = new Account(225, 13546); //creates Account 2 object using no arg constructor in Account class
  Account2.setAnnualInterestRate(5.4); //Uses Account class mehtod to set annual interest rate
  AccountData(2, Account2); //Displays Account data

  CheckingAccount Account3 = new CheckingAccount(); //Creates a checking account object using checking account subclass
  //Uses methods in checking account subclass to set data values for Account 3
  Account3.setId(454);
  Account3.setBalance(2000);
  Account3.setAnnualInterestRate(1.2);
  System.out.println(Account3); //prints Account 3 using to string override method in checking account subclass
  AccountData(3, Account3); //Display Account data

  SavingsAccount Account4 = new SavingsAccount(); //creates Account 4 using savings account subclass
  Account4.setId(332);
  Account4.setBalance(250.3);
  Account4.setAnnualInterestRate(6.3);
  System.out.println(Account4); //prints account 3 using string override method in savings account subclass
  AccountData(4, Account4); //Displays account data

  System.out.println("How much to deposit into account 1?"); //Asks user to enter a value for deposit
  double deposit = input.nextDouble(); //saves user entry to variable
  if (deposit < 1) { //runs if value less than 1 entered
   while (deposit < 1) { //runs until value greater than 1 is entered
    System.out.println("Must be greater than 0"); //prints error
    deposit = input.nextDouble(); //saves user entry to variable
   } //end while
   double currentBalance = Account1.getBalance(); // sets current balance variable to account1 balance
   double newBalance = currentBalance + deposit; //sets newBalance to current account balance plus user entry
   Account1.setBalance(newBalance); //sets account balance to newBalance
   AccountData(1, Account1); //Displays acount data
  } //end if
  else { //runs if value greater than 1 entered on first try
   double currentBalance = Account1.getBalance(); // sets current balance variable to account1 balance
   double newBalance = currentBalance + deposit; //sets newBalance to current account balance plus user entry
   Account1.setBalance(newBalance); //sets account balance to newBalance
   AccountData(1, Account1); //Displays acount data
  } //end else


  System.out.println("How much to withdraw from account 3?"); //asks users to enter an amount to withdraw
  double withdraw = input.nextDouble(); //sets variable to amount entered
  if (withdraw < 1) { //runs if values lest than 1 entered
   while (withdraw < 1) { //runs until value greater than 1 entered
    System.out.println("Must be greater than 0"); //prints error
    withdraw = input.nextDouble(); //sets variable to user entry
   } //end while
   double currentBalance = Account3.getBalance(); // sets current balance variable to account3 balance
   double newBalance = currentBalance - withdraw; //sets new balance to account 3 balance minus the user amount entered
   if (newBalance <= Account3.overdraftLimit) { //runs if value is over the overdraft limit in checking account subclass
    System.out.println("Overdraft limit reached"); //prints error
    newBalance = -10000; //sets newBalance to overdraft limit
   } //end if
   Account3.setBalance(newBalance); //sets account balance to newBalance
   AccountData(3, Account3); //Displays Account data
  } //end if
  else { //runs if value greater than 1 entered on 1st try
   double currentBalance = Account3.getBalance(); // sets current balance variable to account3 balance
   double newBalance = currentBalance - withdraw; //sets new balance to account 3 balance minus the user amount entered
   if (newBalance <= Account3.overdraftLimit) { //runs if value is over the overdraft limit in checking account subclass
    System.out.println("Overdraft limit reached"); //prints error
    newBalance = -10000; //sets newBalance to overdraft limit
   } //end if
   Account3.setBalance(newBalance); //sets account balance to newBalance
   AccountData(3, Account3); //Displays Account data
  } //end else
 } //end main method
 public static void AccountData(int accountNum, Account account) { //Account Data method
  String accountName = "Account " + accountNum; //uses args to create accountName
  System.out.println(accountName); //prints accout name
  System.out.println("Date Created: " + account.getDateCreated()); //uses method to get account creation date and prints
  System.out.println("ID: " + account.getId()); //gets id and prints
  System.out.println("Balance: $" + account.getBalance()); //gets balance and prints
  System.out.println("Annual Interest Rate: " + account.getAnnualInterestRate() + "%"); //gets annual interest rate and prints
  System.out.println("Monthly Interest Rate: $" + account.getMonthlyInterest()); //gets monthly interest and prints
  System.out.println("--------------------");
 } //end method
} //end class