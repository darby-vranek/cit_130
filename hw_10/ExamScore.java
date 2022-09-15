
public class ExamScore {
	private String name; // the name of the exam, such as 'Midterm'
	private int score; // total points earned

	/// default constructor: no args
	public ExamScore() {
		this.setName("Exam 1");
		this.setScore(100);
	}

	/// constructor: accepts user input
	/// @param name (String) - exam name e.g. 'midterm' or 'pop quiz'
	/// @param score (int)
	public ExamScore(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/// getName: public getter for private this.name
	/// @return String
	public String getName() {
		return this.name;
	}

	/// getScore: public getter for private this.score
	/// @return int
	public int getScore() {
		return this.score;
	}

	/// setName: public setter for private this.name
	/// @param name (String)
	/// @return none
	public void setName(String name) {
		this.name = name;
	}

	/// setScore: public setter for private this.score
	/// @param score (int)
	/// @return none
	public void setScore(int score) {
		this.score = score;
	}

	/// toString: returns a string representation of this class
	/// @return String - class information formatted as requested for console
	public String toString() {
		return "Exam Name: " + this.getName() + " Score: " + this.getScore();
	}
}
