/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing
/// this assignment.
/// @file Pa10.java
/// @version The date as 2022-04-05
/// @brief This is a test class that explores the functionality
/// of an object class called ExamScore and its derived class
/// StudentScore
/// @note completed in around 4 hours


import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;


public class Pa10 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // initialize scanner to accept input

		/// initialize default ExamScore object using constructor with no arguments
		ExamScore defaultExam = new ExamScore();
		System.out.println(defaultExam);

		/// initialize default StudentScore object using constructor with no arguments
		StudentScore defaultStudent = new StudentScore();
		System.out.println(defaultStudent);

		System.out.println("Enter the name of an exam and the corresponding score");
		String examName = input.nextLine(); // user input: to assign to ExamScore.name
		int examScore = Integer.parseInt(input.nextLine()); // user input: for ExamScore.score
		/// create ExamScore object with user input
		ExamScore exam = new ExamScore(examName, examScore);

		System.out.println("just updated information for an exam");
		System.out.println(exam);

		System.out.println("Enter the identification number for a student");
		int studentId = Integer.parseInt(input.nextLine()); // user input: for StudentScore.studentId
		System.out.println("Enter the name of an exam and the corresponding score for: " + studentId);
		String studentName = input.nextLine(); // user input: for StudentScore.name
		int studentScore = Integer.parseInt(input.nextLine()); // user input: for StudentScore.score
		/// create new StudentScore object with user input values
		StudentScore student = new StudentScore(studentId);
		student.setName(studentName);
		student.setScore(studentScore);
		System.out.println(student);

		System.out.println("The array data");
		System.out.println("Enter the number of objects to create");
		int num = Integer.parseInt(input.nextLine()); // user input for array object count
		/// create expandable list to add objects to
		ArrayList<StudentScore> studentScores = new ArrayList<StudentScore>();

		/// loop through as many times as indicated by num
		for (int i = 0; i < num; i++) {
			// get random int between 1 and 100 (inclusive)
			/// multiply result of Math.random() by 100 the total number of points that
			/// can be earned, then round up to the nearest int to exclude 0 and include 100
			int score = (int)Math.ceil(Math.random() * 100);
			/// get a random int between 100 and 1000, similar to above except
			/// 900 instead of 100 because 1000-100 = 900
			/// and add 100 to start value
			int id = 100 + (int)Math.ceil(Math.random() * 900);
			/// create new StudentScore object using random values
			StudentScore s = new StudentScore(id);
			s.setName("FINAL PROJECT");
			s.setScore(score);
			/// add new StudentScore object to studentScores list
			studentScores.add(s);
			System.out.println(s);
		}
	}
}
