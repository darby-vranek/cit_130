/* SavingsAccount.java:  - CIT130: Java Programming */
/*
 * Author:
 * Due Date:
 * Time taken to complete exercie
 */

/*Program Purpose
 * **********
 * A subclass that extends the account class overriding the toString method and adding overdraftLimit and monthlyFee
 * variables
 * *****************
 */
public class SavingsAccount extends Account { //Savings account sub class extends Account class
 private double overdraftLimit = -2000; //declare variable overdraftLimit wiht -2000
 private double monthlyFee = 5; //declare monthlyFee variable with value of 5

 public String toString() { //toString method override printing account type
  String accountType = "Savings Account";
  return accountType;
 }
}