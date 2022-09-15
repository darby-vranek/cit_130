// I skipped the satndard headings here
// I hope you know how this is done!

// define the rectangle class so we can instantiate it later
public class Rectangle {

  // define the data for the object
  private double width;
  private double length;
  private double area;
  private double perimeter;

  // no-arg constructor that sets all vals to 1
  Rectangle() {

    width = 1;
    length = 1;
    area = 1;
    perimeter = 1;
  }

  // arg constructor that defines the width, and length based on input and calculates the area/perimeter
  Rectangle(double newWidth, double newLength) {

    width = newWidth;
    length = newLength;
    setArea();
    setPerimeter();

  }

  // set the width. self-explanatory.
  public void setWidth(double newWidth) {

    width = newWidth;
  }

  public void setLength(double newLength) {

    length = newLength;
  }

  // calculates the area
  public void setArea() {

    area = length * width;
  }

  // calculates the perimeter
  public void setPerimeter() {

    perimeter = 2 * (length + width);
  }

  public double getWidth() {

    return width;
  }

  public double getLength() {

    return length;
  }

  public double getArea() {

    return area;
  }

  public double getPerimeter() {

    return perimeter;
  }

  // It's best to use the toString method, so the output of an object is more natural
  //note that the member attributes can be directly accessed, so there is no need to call the get methods within the class
  public String toString()
  {
    return "The width of the rectangle is: " + width +
    ", the length of the rectangle is: " + length +
    ", the area of the rectangle is: " + area +
    ", the perimeter of the rectangle is: " + perimeter + "\n";
  }
}//Rectangle