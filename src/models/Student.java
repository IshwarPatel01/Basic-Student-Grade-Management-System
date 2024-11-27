package models;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Integer> grades;

    public Student(int id, String name, List<Integer> grades){
    this.id = id;
    this.name = name;
    this.grades = grades;
}

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public List<Integer> getGrades(){
        return grades;
    }
    public double calculateAverage(){
        int total = 0;
        for(int grade : grades){
            total += grade;
        }
        return grades.isEmpty() ? 0 : (double) total /grades.size();
    }
    @Override
    public String toString(){
        return  "ID: " + id + ", Name: " + name + ", Grades: " + grades + ", Average: " + calculateAverage();
    }

}
