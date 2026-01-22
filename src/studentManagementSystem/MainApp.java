package studentManagementSystem;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAO();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("\n===== Student Management System =====");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.println("Enter Your Choice: ");
			
			choice = sc.nextInt();
			sc.nextLine();     			//consume newLine
			
			switch(choice) {
				case 1:
					System.out.print("Enter name: ");
					String name = sc.nextLine();
					
					System.out.print("Enter email: ");
					String email = sc.nextLine();
					
					System.out.print("Enter course: ");
					String course = sc.nextLine();
					
					System.out.print("Enter marks: ");
					int marks = sc.nextInt();
					
					dao.addStudent(new Student(name, email, course, marks));
					break;
					
				case 2:
					dao.viewAllStudents();
					break;
					
				case 3:
					System.out.print("Enter student ID to update: ");
					int id = sc.nextInt();
					sc.nextLine();
					
					System.out.print("Enter new name: ");
					String newName = sc.nextLine();
					
					System.out.print("Enter new email: ");
					String newEmail = sc.nextLine();
					
					System.out.print("Enter new course: ");
					String newCourse = sc.nextLine();
					
					System.out.print("Enter new marks: ");
					int newMarks = sc.nextInt();
					
					dao.updateStudent(id, newName, newEmail, newCourse, newMarks);
					break;
					
				case 4:
					System.out.print("Enter student ID to delete: ");
					int deleteId = sc.nextInt();
					
					dao.deleteStudent(deleteId);
					break;
					
				case 5:
					System.out.println("Exiting application...");
					break;
					
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}while(choice!=5);
		
		sc.close();
	}
}
