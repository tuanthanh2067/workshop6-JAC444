package Main;

import Student.Student;
import Student.ReadStudent;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Scanner sc = new Scanner(System.in);
            int input = 1;
            System.out.println("Type in student information following this format");
            System.out.println("ID(integer) FirstName(String) LastName(String) Courses(array)");
            while (input == 1) {
                Student stu = ReadStudent.readStudentFromKeyBoard();
                students.add(stu);
                System.out.print("Do you want to continue? (1: Yes/ 0: Done): ");
                input = sc.nextInt();
            }
            ReadStudent.writeStudentsToFile(students);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
