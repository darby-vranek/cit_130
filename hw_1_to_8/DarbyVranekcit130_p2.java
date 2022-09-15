/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing
/// this assignment.
/// @file DarbyVranekcit130_p2.java
/// @version 2022-02-01
/// @brief Calculates the price of a book after markup and discount,
/// estimates the value of π, and calculates body mass index
/// @note Approximately 2 hours to complete

/// Get book price
///   input initial book price
///   input markup rate
///   input discount rate
///   mark up price
///   find discount
///   calculate final price
///   display results

/// Estimate pi
///   apply formula
///   display result

/// compute bmi
///   get weight input
///   get height in feet
///   get height inches
///   calculate total height in inches
///   apply BMI formula using weight and height
///   display result

/// this line was automatically generated by netbeans and I'm not sure if I need it
package DarbyVranekcit130_p2;

import java.util.Scanner;

public class DarbyVranekcit130_p2 {
  /// calculates marked up and discounted book price,
  /// estimates the value of pi, calculates BMI
  /// @param = none
  /// @return - none
  public static void main(String[] args) {
    double bookOriginalPrice; // user input for original book price
    double bookMarkupRate; // user input for book's markup rate
    double bookMarkupPrice; // price of marked up book
    double bookDiscountRate; // user input for book's discount rate
    double bookDiscount; // discount value based on discount rate and markup price
    double piValue; // calculated value of pi
    double feet; // user input for feet portion of height
    double inches; // user input for inches portion of height
    double height; // total height converted to inches
    double weight; // user input for weight in pounds
    double bmi; // calculated BMI based on height and weight

    // initialize scanner to allow user input
    Scanner input = new Scanner(System.in);

    // get book price, markup, discount from user
    System.out.println("question 1");
    System.out.print("Enter the original price: ");
    bookOriginalPrice = input.nextDouble();
    System.out.print("Enter the markup rate: ");
    bookMarkupRate = input.nextDouble();
    System.out.print("Enter the discount rate: ");
    bookDiscountRate = input.nextDouble();

    // calculate book prices based on user input
    // convert markup and discount percentage to decimals
    bookMarkupPrice = bookOriginalPrice * ((bookMarkupRate + 100) / 100);
    bookDiscount = (bookMarkupPrice * bookDiscountRate) / 100;

    // print book pricing information
    System.out.println("\n************ Foo’s Bookstore");
    System.out.println("Original price = $" + bookOriginalPrice);
    System.out.println("Markup rate = " + bookMarkupRate + "%");
    System.out.println("Discount rate = " + bookDiscountRate + "%");
    System.out.println("Price after Markup = $" + bookMarkupPrice);
    System.out.println("Discount = $" + bookDiscount);
    System.out.println("Please pay: $" + (bookMarkupPrice - bookDiscount));

    // estimate and print the value of pi based on given formula
    piValue = 4 * (1 - (1/3.0) + (1/5.0) - (1/7.0) + (1/9.0) - (1/11.0) + (1/13.0));
    System.out.println("\nThe value of PI = " + piValue);

    // get height and weight user input
    System.out.println("\nquestion 3");
    System.out.print("Enter your weight in pounds = ");
    weight = input.nextDouble();
    System.out.print("Enter your height in feet = ");
    feet = input.nextDouble();
    System.out.print("Enter your height in inches = ");
    inches = input.nextDouble();
    // convert height feet'inches" format to inches
    height = (feet * 12.0) + inches;
    // apply bmi formula to height and weight and display value
    bmi = weight * (703.0 / (height * height));
    System.out.println("BMI = " + bmi);
  }
}
