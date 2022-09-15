/// define the Pool class to instantiate in test class
public class Pool {
		/// define the data for the object
		private String color;
		private double length; // feet
		private double width; // feet
		private double depth; // feet
		private double surfaceArea; // feet^2 (length * width)
		private double volume; // feet^3 (length * width * depth)

		// no-arg constructor
		Pool() {
			// assign object with default values
			color = "Default";
			length = 0;
			width = 0;
			depth = 0;
			// calculate and set surfaceArea and volume once length/width/depth are defined
			setSurfaceArea();
			setVolume();
		}

		// constructor to accept defined values
		Pool(String color, double length, double width, double depth) {
			this.color = color;
			this.length = length;
			this.width = width;
			this.depth = depth;
			// calculate and set surfaceArea and volume once length/width/depth are defined
			setSurfaceArea();
			setVolume();
		}

		// setColor - SETTER for this.color
		/// @param color (String) - the new value for this.color
		/// @return none
		public void setColor(String color) {
			this.color = color;
		}

		/// setLength - SETTER for this.length
		/// @param length (double) - new value for this.length, in feet
		/// @return none
		public void setLength(double length) {
			this.length = length;
			// update surfaceArea and volume based on new length
			setSurfaceArea();
			setVolume();
		}

		/// setWidth - SETTER for this.width
		/// @param length (double) - new value for this.width, in feet
		/// @return none
		public void setWidth(double width) {
			this.width = width;
			// update surfaceArea and volume based on new width
			setSurfaceArea();
			setVolume();
		}

		/// setDepth - SETTER for this.depth
		/// @param length (double) - new value for this.depth, in feet
		/// @return none
		public void setDepth(double depth) {
			this.depth = depth;
			// update volume based on new depth
			setVolume();
		}

		/// setSurfaceArea - calculates surface area using length width values
		/// @return none
		public void setSurfaceArea() {
			surfaceArea = length * width;
		}

		/// setVolume - calculates volume area using length, width, and depth values
		/// @return none
		public void setVolume() {
			volume = length * width * depth;
		}

		/// getColor - GETTER for this.color
		/// @return (String) - value of this.color
		public String getColor() {
			return color;
		}

		/// getLength - GETTER for this.length
		/// @return (double) - value of this.length given in feet
		public double getLength() {
			return length;
		}

		/// getWidth - GETTER for this.width
		/// @return (double) - value of this.width given in feet
		public double getWidth() {
			return width;
		}

		/// getDepth - GETTER for this.depth
		/// @return (double) - value of this.depth given in feet
		public double getDepth() {
			return depth;
		}

		/// getSurfaceArea - GETTER for this.surfaceArea
		/// @return (double) - value of this.surfaceArea given in square feet
		public double getSurfaceArea() {
			return surfaceArea;
		}

		/// getVolume - GETTER for this.volume
		/// @return (double) - value of this.volume given in cubic feet
		public double getVolume() {
			return volume;
		}

		/// display - a series of print statements for a formatted longform display
		/// of the Pool's values
		/// @return none
		public void display() {
			System.out.println("*** Pool Report");
			System.out.println("The color of the pool is " + color);
			System.out.println("The length of the pool is " + length + " feet.");
			System.out.println("The width of the pool is " + width + " feet.");
			System.out.println("The depth of the pool is " + depth + " feet.");
			System.out.println("The area of the pool is " + surfaceArea + " square feet.");
			System.out.println("The volume of the pool is " + volume + " cubic feet.");
		}

		/// toString - defined string representation for class
		/// @return (String) - a basic string representation of the class's values
		public String toString() {
			return "Color: " + color + " | Length: " + length + " | Width: " + width + " | Depth: " + depth + " | Area: " + surfaceArea + "  | Volume: " + volume;
		}
}
