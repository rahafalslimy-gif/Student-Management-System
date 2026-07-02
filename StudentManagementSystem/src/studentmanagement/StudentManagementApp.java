package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp {
	static ArrayList<Student> students = new ArrayList<>();
	static Scanner input = new Scanner(System.in);


	public static void main(String[] args) {


		int choice;

		do {

			System.out.println("\n===== Student Management System =====");
			System.out.println("1. Add Student");
			System.out.println("2. Add Marks");
			System.out.println("3. Display All Students");
			System.out.println("4. Search Student");
			System.out.println("5. Show Top Student");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			choice = input.nextInt();

			switch (choice) {

			case 1:
				addStudent();
				break;

			case 2:
				addMarks();
				break;

			case 3:
				displayStudents();
				break;

			case 4:
				searchStudent();
				break;

			case 5:
				showTopStudent();
				break;

			case 6:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 6);

	}

	public static void addStudent() {

		System.out.print("Enter Student ID: ");
		int id = input.nextInt();

		// Check if ID already exists
		for (Student student : students) {
			if (student.getId() == id) {
				System.out.println("Student ID already exists!");
				return;
			}
		}

		input.nextLine();

		System.out.print("Enter Student Name: ");
		String name = input.nextLine();

		if (name.isEmpty()) {
			System.out.println("Name cannot be empty.");
			return;
		}

		System.out.print("Enter Student Age: ");
		int age = input.nextInt();

		if (age <= 0) {
			System.out.println("Age must be greater than 0.");
			return;
		}

		Student student = new Student(id, name, age);
		students.add(student);

		System.out.println("Student added successfully.");
	}

	public static void addMarks() {

		System.out.print("Enter Student ID: ");
		int id = input.nextInt();

		for (Student student : students) {

			if (student.getId() == id) {

				System.out.print("How many marks do you want to add? ");
				int count = input.nextInt();

				for (int i = 1; i <= count; i++) {

					System.out.print("Enter mark " + i + ": ");
					int mark = input.nextInt();

					if (mark < 0 || mark > 100) {
						System.out.println("Invalid mark. Must be between 0 and 100.");
						i--;
						continue;
					}

					student.addMark(mark);
				}

				return;
			}
		}

		System.out.println("Student not found.");
	}

	public static void displayStudents() {

		if (students.isEmpty()) {
			System.out.println("No students found.");
			return;
		}

		for (Student student : students) {
			student.displayStudentInfo();
		}
	}

	public static void searchStudent() {

		System.out.print("Enter Student ID: ");
		int id = input.nextInt();

		for (Student student : students) {

			if (student.getId() == id) {
				student.displayStudentInfo();
				return;
			}
		}

		System.out.println("Student not found.");
	}

	public static void showTopStudent() {

		if (students.isEmpty()) {
			System.out.println("No students available.");
			return;
		}

		Student topStudent = students.get(0);

		for (Student student : students) {

			if (student.calculateAverage() > topStudent.calculateAverage()) {

				topStudent = student;
			}
		}

		System.out.println("Top Student:");
		topStudent.displayStudentInfo();
	}

}
