package Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadStudent {
    private static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

    public static void writeStudentsToFile(ArrayList<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream("students.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);

            oos.flush(); // make sure this happens right now
            fos.close(); // close
        }  catch(Throwable e) {
            System.err.println(e);
        }
    }

    public static Student readStudentFromKeyBoard() throws Exception {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String[] arr = temp.split("\\s+");

        if (arr.length <= 2) {
            throw new Exception("Not enough information");
        }

        if (!isParsable(arr[0])) {
            throw new Exception("Wrong id format");
        }
        int stnId = Integer.parseInt(arr[0]);

        ArrayList<String> courses = new ArrayList<String>();
        for (int i = 3; i < arr.length; i++) {
            courses.add(arr[i]);
        }
        return new Student(stnId, arr[1], arr[2], courses);
    }


}
