package Student;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ReadStudent extends JFrame {
    public ReadStudent() {
        super("Read student Frame");
        setLayout(new FlowLayout());
        this.setSize(425, 200);
        this.setVisible(true);

        ArrayList<Student> returnStudents = ReadStudentsFromFile("students.out");

        for (int i = 0; i < returnStudents.size(); i++) {
            JLabel label = new JLabel("Student " + (i + 1));
            add(label);

            JTextField textField = new JTextField(returnStudents.get(i).toString());
            textField.setEditable(false);
            add(textField);
        }
    }

    private static ArrayList<Student> ReadStudentsFromFile(String file) {
        ArrayList<Student> students = new ArrayList<>();;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            students = (ArrayList<Student>) ois.readObject();
            fis.close();
        } catch (Throwable e) {
            System.err.println(e);
        }
        return students;
    }


}
