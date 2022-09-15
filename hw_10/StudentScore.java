
/// class extends ExamScore, adding the studentID field
public class StudentScore extends ExamScore {
	private int studentId;

	/// constructor - default values
	public StudentScore() {
		/// calls parent constructor to assign default values for
		/// this.name and this.score, which are defined in the
		/// parent class
		super();
		studentId = 1000;
	}

	/// constructor - with specified studentId
	public StudentScore(int studentId) {
		/// call parent constructor, assign default values
		super();
		/// assign studentId arg to field
		this.studentId = studentId;
	}

	/// getStudentId - public getter for private variable this.studentId
	/// @return int
	public int getStudentId() {
		return this.studentId;
	}

	/// setStudentId - public setter for private variable this.studentId
	/// @param studentId (int) - the student's ID number
	/// @param studentName (String) - the name of the exam
	/// @param studentScore (int) - the student's test score for the exam
	/// return none
	public void setStudentId(int studentId, String studentName, int studentScore) {
		this.studentId = studentId;
		// use to interact with private base class fields
		setName(studentName);
		setScore(studentScore);
	}

	/// toString - override, returns a string representation of the object
	/// @return String
	public String toString() {
		return "Exam Name: " + this.getName() + " Score: " + this.getScore() + " Identification Number: " + this.getStudentId();
	}
}
