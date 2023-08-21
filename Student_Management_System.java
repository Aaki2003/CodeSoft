package Task_2_codesoft;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String rollNumber;
    private String grade;

    public Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class Student_Management {
    private ArrayList<Student> students;

    public Student_Management() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String rollNumber) {
        students.removeIf(student -> student.getRollNumber().equals(rollNumber));
    }

    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class Student_Management_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student_Management sms = new Student_Management();

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add a Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Search for a Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter student name:");
                    String name = sc.next();

                    System.out.println("Enter roll number: ");
                    String rollNumber = sc.next();

                    System.out.println("Enter grade: ");
                    String grade = sc.next();

                    if (!name.isEmpty() && !rollNumber.isEmpty() && !grade.isEmpty()) {
                        Student student = new Student(name, rollNumber, grade);
                        sms.addStudent(student);
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("All fields must be filled.");
                    }
                    break;

                case 2:
                    System.out.println("Enter roll number of the student to remove: ");
                    rollNumber = sc.nextLine();
                    sms.removeStudent(rollNumber);
                    System.out.println("Student removed successfully.");
                    break;

                case 3:
                    System.out.println("Enter roll number of the student to search: ");
                    rollNumber = sc.nextLine();
                    Student foundStudent = sms.searchStudent(rollNumber);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting Student Management System.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
