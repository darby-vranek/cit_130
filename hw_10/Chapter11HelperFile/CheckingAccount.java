/* CheckingAccount.java: - CIT130: Java Programming */
/*
 * Author:
 * Due Date:
 * Time taken to complete exercie
 */

/*Program Purpose
 * **********
 * A subclass that extends the account class overriding the toString method and adding overdraftLimit variable
 * *****************
 */
public class CheckingAccount extends Account { //Checking Account subclass exting Account class

 double overdraftLimit = -10000; //declare variable overdraftLimit with value of -10000


 //override to string method to print checking account
 public String toString() {
  String accountType = "Checking Account";
  return accountType;
 }
}