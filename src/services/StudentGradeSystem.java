package services;

import models.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentGradeSystem {
    private List<Student> students = new ArrayList<>();

    public void addStudent(int id, String name, List<Integer> grades) {
        students.add(new Student(id, name, grades));
        System.out.println("Student added successfully.");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void viewGradeStats() {
        if (students.isEmpty()) {
            System.out.println("No data to display.");
            return;
        }
        double totalAverage = 0;
        int highestGrade = Integer.MIN_VALUE;
        int lowestGrade = Integer.MAX_VALUE;

        for (Student student : students) {
            for (int grade : student.getGrades()) {
                if (grade > highestGrade) highestGrade = grade;
                if (grade < lowestGrade) lowestGrade = grade;
            }
            totalAverage += student.calculateAverage();
        }
        System.out.println("Class Average: " + totalAverage / students.size());
        System.out.println("Highest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowestGrade);
    }

    public void searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}
