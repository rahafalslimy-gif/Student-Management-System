package studentmanagement;
import java.util.ArrayList;
public class Student {
	private int id;
	private String name;
	private int age;
	private ArrayList<Integer> marks;

	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void addMark(int mark) {
		if (mark >= 0 && mark <= 100) {
			marks.add(mark);
		}
	}

	public double calculateAverage() {

		if (marks.isEmpty()) {
			return 0;
		}

		int sum = 0;

		for (int mark : marks) {
			sum += mark;
		}

		return (double) sum / marks.size();
	}

	public String calculateGrade() {

		double avg = calculateAverage();

		if (avg >= 90) {
			return "A";
		} else if (avg >= 80) {
			return "B";
		} else if (avg >= 70) {
			return "C";
		} else if (avg >= 60) {
			return "D";
		} else {
			return "F";
		}
	}

	public void displayStudentInfo() {

		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Number of Marks: " + marks.size());
		System.out.println("Average: " + calculateAverage());
		System.out.println("Grade: " + calculateGrade());
	}
}

