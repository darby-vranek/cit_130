// I skipped the satndard headings here
// I hope you know how this is done!


import java.util.Scanner;

public class RectangleTest {

  public static void main(String[] args) {

    // define the scanner object to take input
    Scanner input = new Scanner(System.in);

    // no arg rectangle object #1
    Rectangle rec1 = new Rectangle();

    // print the rectangle's data
    System.out.println(rec1);

    // define rectangles 2, and 3 with specified width/length values
    Rectangle rec2 = new Rectangle(10, 20);

    Rectangle rec3 = new Rectangle(7, 30);

    System.out.println(rec2);

    System.out.println(rec3);


    // Now inform the user that a new rectangle is being created
    System.out.println("We are now creating a new rectangle.");

    // ask them for the width and length of the rectangle object being created
    System.out.print("Enter the width: ");
    double newWidth = input.nextDouble();

    System.out.print("Enter the length: ");
    double newLength = input.nextDouble();

    // create the rectangle with the given input
    Rectangle rec4 = new Rectangle(newWidth, newLength);

    System.out.println("The data for the rectangle you just created is as follows...");

    System.out.println(rec4);


    // create the array of rectangles
    Rectangle[] rectangleArray = new Rectangle[10];


    for(int x = 0; x < rectangleArray.length; x++) {

      // instantiate the rectangle
      rectangleArray[x] = new Rectangle(x + 1, x + 1);

      // calculate it's area/perimeter
      rectangleArray[x].setArea();
      rectangleArray[x].setPerimeter();

      // display the data for the generated rectangle
      System.out.println("The data for rectangle " + (x + 1) + " is as follows...");

      System.out.println(rectangleArray[x]);
    }
  }
}// RectangleTest
