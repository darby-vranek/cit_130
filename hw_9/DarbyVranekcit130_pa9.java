import java.util.Scanner;

public class DarbyVranekcit130_pa9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Scanner object to take input
		/// variables to hold scanner input for user-defined pool data
		String color;
		double length;
		double width;
		double depth;
		/// pool objects and array to be created later in the program
		Pool defaultPool; // pool object to be created with empty constructor
		Pool userPool; // pool object to populate with user input
		Pool[] poolArr; // array to hold user defined pools
		int poolCount; // user input for size of poolArr
		/// !!QUESTION!! is it better for me to decare these temporary
		/// variables and Pool objects here at the top, or should I be defining
		/// them as I go along?
		/// thank you!

		/// initialize pool object with empty constructor to use default values
		System.out.println("\n=== using a no-arg construtor ===");
		defaultPool = new Pool();
		System.out.println(defaultPool);

		/// accept color, length, width, and depth args from user to create pool object
		System.out.println("\n\n=== processing a user created pool ===");
		System.out.print("Enter the color of a pool: ");
		color = input.next();
		System.out.print("Enter the length of a pool: ");
		length = input.nextDouble();
		System.out.print("Enter the width of a pool: ");
		width = input.nextDouble();
		System.out.print("Enter the depth of a pool: ");
		depth = input.nextDouble();
		/// use pool constructor with user input args
		userPool = new Pool(color, length, width, depth);
		userPool.display();
		System.out.println("*** using the toString method");
		System.out.println(userPool);

		System.out.println("\n\n=== processing an array of user created pools ===");
		/// get pool count from user and initialize empty array
		System.out.print("How many pools to create? ");
		poolCount = input.nextInt();
		poolArr = new Pool[poolCount];

		/// create and display pools to fill poolArr
    for (int i = 0; i < poolCount; i++) {
			System.out.println("\n*** Processing Pool #" + (i+1));
			System.out.print("Enter the color of the pool: ");
			color = input.next();
			System.out.print("Enter the length of the pool: ");
			length = input.nextDouble();
			System.out.print("Enter the width of the pool: ");
			width = input.nextDouble();
			System.out.print("Enter the depth of the pool: ");
			depth = input.nextDouble();
			/// use pool constructor with user input args
			poolArr[i] = new Pool(color, length, width, depth);
			poolArr[i].display();
		}

		System.out.println("\n*** display toString for every pool in array");
		/// loop through every pool in poolArr and print
		for (int i = 0; i < poolCount; i++) {
			System.out.println((i + 1) + ". " + poolArr[i]);
		}
	}
}
