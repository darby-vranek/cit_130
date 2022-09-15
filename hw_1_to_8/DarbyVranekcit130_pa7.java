/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing /// this assignment.
/// @file DarbyVranekcit130_pa7.java
/// @version The date as 2022-03-15
/// @brief Write a program to process scores for a set of students. Arrays and
/// methods must be used for this program. Based on material from chapter 7.
/// @note took approximately 3 hours to complete

import java.util.Scanner;

public class DarbyVranekcit130_pa6 {
	public static Scanner input; // global input variable to be shared

	public static int getStudentCount() {
		boolean validCount;
		int count;

		System.out.print("Enter number of students: ");
		count = input.nextInt();
		if (count > 0) {
			validCount = true;
		} else {
			validCount = false;
		}
		while (validCount == false) {
			System.out.print("Invalid try again: ");
			count = input.nextInt();
			if (count > 0) {
				validCount = true;
			} else {
				validCount = false;
			}
		}
		return count;
	}

	/// getStudentData - populates referenced arrays with names and test scores
	/// based on user input
	/// @param names (String[]) - a reference to an initialized String[] to hold
	/// student names, sized to fit the input number of students
	/// @param scores (double[]) - a reference to an initialized double[] to hold
	/// each student's score, sized to fit the input number of students
	/// @return - none
	public static void getStudentData(String[] names, double[] scores) {
		System.out.println("Enter the name and test score for the students:");
		/// prompt the user to input as many students as will fill the pre-sized
		/// arrays
		for (int i = 0; i < names.length; i++) {
			names[i] = input.next();
			scores[i] = input.nextDouble();
		}
	}

	/// getAverage - calculates the average score from a double[]
	/// @param scores (double[]) - an array of all the values to be averaged
	/// @return (double) - the sum of all values of the array, divided by the
	/// number of scores
	public static double getAverage(double[] scores) {
		double sum; // variable to hold the sum of each score in scores
		double average; // variable to hold the sum divided by the number of scores
		sum = 0; // sum must be assigned a value before looping
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		average = sum / scores.length;
		return average;
	}

	/// getVariance - calculates the variance of a double[]
	/// @param scores (double[]) - a list of all scores to be assessed
	/// @return (double) - returns the output after running all values from scores
	/// through the variance formula
	public static double getVariance(double[] scores) {
		double average; /// the sum of all scores divided by the number of scores
		double variance; /// to be calculated based on variance formula

		average = getAverage(scores);
		variance = 0;
		for (int i = 0; i < scores.length; i++) {
			// first step of variance calculation formula
			variance += Math.pow((scores[i] - average), 2);
		}
		// final step of variance calculation formula
		variance /= (scores.length - 1);
		return variance;
	}

	/// sortScores - takes references to names and scores arrays and then sorts them
	/// by scores, from low to high
	/// @param names - String[] of all student names, to be sorted alongside scores
	/// @param scores - double[] of student scores, to be sorted from low to high
	public static void sortScores(String[] names, double[] scores) {
		double currentMin; // the lowest score found in scores during loops
		int currentMinIndex; // the index of the current lowest found score

		/// sorted using algorithm from chapter 7, adjusted to also sort names
		currentMin = scores[0];
		for (int i = 0; i < scores.length - 1; i++) {
			/// start each loop by setting scores[i] as the current lowest found number
			currentMin = scores[i];
			currentMinIndex = i;

			/// loop through all remaining values in the array to determine the
			/// smallest remaining value
			for (int j = i + 1; j < scores.length; j++) {
				if (currentMin > scores[j]) {
					currentMin = scores[j];
					currentMinIndex = j;
				}
			}

			/// swap the currently identified lowest value with lowest identified
			/// value to sort lists
			if (currentMinIndex != i) {
				String temp = names[currentMinIndex];
				scores[currentMinIndex] = scores[i];
				scores[i] = currentMin;
				names[currentMinIndex] = names[i];
				names[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int studentCount; /// user input, the number of students to be processed
		String[] studentNames; /// array to hold all input names of students
		double[] studentScores; /// array to hold each student's score
		double average; /// calculated average of all test scores
		double variance; /// calculated variance of all test scores

		input = new Scanner(System.in);

		studentCount = getStudentCount();
		/// initialize studentNames and studentScores sized for the number of students
		studentNames = new String[studentCount];
		studentScores = new double[studentCount];
		getStudentData(studentNames, studentScores);
		System.out.println("*** here is what I have for your data ***");

		/// loop through each student and score and display
		for (int i = 0; i < studentCount; i++) {
			System.out.printf("%s %.2f\n", studentNames[i], studentScores[i]);
		}

		sortScores(studentNames, studentScores);

		System.out.println("*** Sorted data ***");

		/// loop through each student and score after sorting and display
		for (int i = 0; i < studentCount; i++) {
			System.out.printf("%s %.2f\n", studentNames[i], studentScores[i]);
		}

		average = getAverage(studentScores);
		variance = getVariance(studentScores);
		System.out.printf("Average = %.2f\n", average);
		System.out.printf("Variance = %.2f", variance);
	}
}
