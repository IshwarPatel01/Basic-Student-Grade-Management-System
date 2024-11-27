package app;

import services.StudentGradeSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeSystem sgs = new StudentGradeSystem();

        while (true) {
            System.out.println("\nStudent Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Grade Statistics");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter Grades (comma-separated): ");
                    String[] gradeInputs = scanner.nextLine().split(",");
                    List<Integer> grades = new ArrayList<>();
                    for (String grade : gradeInputs) {
                        grades.add(Integer.parseInt(grade.trim()));
                    }
                    sgs.addStudent(id, name, grades);
                    break;
                case 2:
                    sgs.viewAllStudents();
                    break;
                case 3:
                    sgs.viewGradeStats();
                    break;
                case 4:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();
                    sgs.searchStudentById(searchId);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
