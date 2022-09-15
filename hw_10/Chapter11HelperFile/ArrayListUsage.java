/* ArrayListUsage.java: - CIT130: Java Programming */
/*
 * Author:
 * Due Date:
 * Time taken to complete exercie
 */

/*Program Purpose
 * **********
 * Main Method: Uses arraylists to create new arraylist based on elements of others, display size of array list, enter
 * and remove lements, and find values by checking elemetns.
 * INPUT VARIABLES:
 * employeeName, newName, menuChoice
 * OUTPUT VARIABLES:
 * menu
 * *****************
 */
//imports
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListUsage {
 public static void main(String[] args) {

  Scanner input = new Scanner(System. in ); //declare variable to accept input

  //creates 4 arrayList's to hold names, payrates, hoursWorked, and employeePay
  ArrayList < String > nameList = new ArrayList < String > ();
  ArrayList < Integer > payRateList = new ArrayList < Integer > ();
  ArrayList < Integer > hoursWorkedList = new ArrayList < Integer > ();
  ArrayList < Integer > employeePayList = new ArrayList < Integer > ();

  //adds 3 elements to nameList arrayList
  nameList.add("James");
  nameList.add("Susan");
  nameList.add("Emily");

  //adds 3 elements to payRate arrayList
  payRateList.add(9);
  payRateList.add(12);
  payRateList.add(6);

  //adds 3 elements to hoursWorked arrayList
  hoursWorkedList.add(40);
  hoursWorkedList.add(28);
  hoursWorkedList.add(13);


  for (int a = 0; a < nameList.size(); a++) { //runs for element in nameList
   int currentPayRate; //declare variables
   int currentHours;
   int currentPay;

   currentPayRate = payRateList.get(a); //sets currentPayRate to value of current element in payRateList
   currentHours = hoursWorkedList.get(a); //sets currentHours to value of current elemtn in hoursWorkedlist
   currentPay = currentHours * currentPayRate; //sets currentPay to currentHours multiplied by currentPayRate
   employeePayList.add(currentPay); //adds currentPay to employeePayList
  }

  int menuChoice = 1; //declares and initialize menuChoice variable

  while (menuChoice != 7) { //runs until menuChoice value equals 7

   menuChoice = menu(); //sets menuChoice to menu method return value

   switch (menuChoice) { //creates a switch statement based on menuChoice values
    case 1:
     //runs if 1 is entered
     //displays the size of each arrayList
     System.out.println("Name List size: " + nameList.size());
     System.out.println("Pay Rate List size: " + payRateList.size());
     System.out.println("Hours Worked List size: " + hoursWorkedList.size());
     System.out.println("Employee Pay List size: " + employeePayList.size());

     break;
    case 2:
     //runs if 2 is entered
     System.out.println("Enter an employee name to find"); //asks user to enter an employee name
     String employeeName = input.next(); //sets employeeName to user entry
     String arrayEmployeeName; //creates String variable called arrayEmployeeName
     int x = 0; //creates and initializes integer x
     for (int a = 0; a < nameList.size(); a++) { //runs for each element in nameList
      arrayEmployeeName = nameList.get(a); //sets arrayEmployeeName to current element in nameList
      //checks if employeeName equals arrayEmployeeName, ignoring case
      if (employeeName.equalsIgnoreCase(arrayEmployeeName)) {
       x = 1; //sets x value to 1
      } //end if
     } //end for
     if (x == 1) { //runs if x equals 1
      System.out.println("Employee Found"); //prints line
     } //end if
     else { //runs if x is not 1
      System.out.println("Employee Not Found"); //printsline
     } //end else

     break;

    case 3:
     //runs if 3 entered
     System.out.println("Enter a name to add"); //asks user to enter a name
     String newName = input.next(); //sets variable to user entry
     nameList.add(newName); //adds name to nameList
     payRateList.add(0); //adds a new element to payRateList with a value of 0
     hoursWorkedList.add(0); //adds a new element to hoursWorkedList with a value of 0
     employeePayList.add(0); //adds a new element to employeePayList with a value of 0

     break;

    case 4:
     System.out.println("Enter a name to remove"); //asks user to enter a name
     employeeName = input.next(); //sets employeeName to user entry
     x = 99; //sets x variable to 99
     int listIndex = 0; //declares and initialise listIndex variable
     for (int a = 0; a < nameList.size(); a++) { //runs for every element in nameList
      arrayEmployeeName = nameList.get(a); //sets arrayEmployeeName to current element in nameList
      //checks if employeeName equals arrayEmployeeName, ignoring case
      if (employeeName.equalsIgnoreCase(arrayEmployeeName)) {
       listIndex = a; //sets listIndex to current element index of nameList
       x = 1; //sets x value to 1
      } //end if
     } //end for
     if (x == 1) { //runs if x is equal to 1
      nameList.remove(listIndex); //removes name, payrate, hours worked, and employee pay
      payRateList.remove(listIndex);
      hoursWorkedList.remove(listIndex);
      employeePayList.remove(listIndex);
       System.out.println("Employee Removed");
     } //end if
     else { //runs if x is not 1
      System.out.println("Error: Employee Not Found"); //prints error
     } //end else

     break;

    case 5:
     //runs if 6 is entered
     //prints the contents of all arrayLists
     System.out.println(nameList);               //NOTE: we don't implicitly call the toString() method.
     System.out.println(payRateList);
     System.out.println(hoursWorkedList);
     System.out.println(employeePayList);

     break;

    case 6:
     System.out.println("Enter an employee name to find their pay"); //asks user to enter a name
     employeeName = input.next(); //sets variable to user netry

     x = 0; //sets x variable to 0
     listIndex = 99; //sets listIndex variable to 99
     for (int a = 0; a < nameList.size(); a++) { //runs for each variable in nameList
      arrayEmployeeName = nameList.get(a); //sets arrayEmployeeName to current element in nameList
      //checks if employeeName equals arrayEmployeeName, ignoring case
      if (employeeName.equalsIgnoreCase(arrayEmployeeName)) {
       x = 1; //sets x value to 1
       listIndex = a; //sets listIndex to current element index of nameList
      } //end if
     } //end for
     if (x == 1) { //runs if x equals 1
      System.out.println("Pay = " + employeePayList.get(listIndex)); //prints pay for employee choses
     } //end if
     else { //runs if x is not 1
      System.out.println("Employee Not Found"); //prints error
     } //end else

     break;

    case 7:
     //runs if 7 is entered
     menuChoice = 7; //sets menu choice value to 9
     break;
   } //end switch

  } //end while
  System.exit(0); //exits program
 } //end main method

 public static int menu() {
  Scanner input = new Scanner(System. in ); // declares variable to accept input
  System.out.println("-------------------------"); //prints line for readability
  //prints lines to choose switch case statements
  System.out.println("1) Display the size of the array lists");
  System.out.println("2) Find Employee by name");
  System.out.println("3) Add names");
  System.out.println("4) Remove names");
  System.out.println("5) Display the contents of the array lists");
  System.out.println("6) Find employee pay by name");
  System.out.println("7) Exit");
  int menu = input.nextInt(); //sets menu value to use entry
  return menu; //returns menu value

 } //end menu method
} //end class