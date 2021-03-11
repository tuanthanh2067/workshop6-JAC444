package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteStudent extends JFrame {
    public WriteStudent() {
        super("Write student Frame");
        setLayout(new FlowLayout());
        setSize(425, 300);
        setVisible(true);

        JLabel label = new JLabel("Enter student info in the format of ID FirstName LastName Courses");
        JLabel label1 = new JLabel("--------------------Go to a new line to add another student--------------------");
        add(label);
        add(label1);

        JLabel st1 = new JLabel("Students: ");
        add(st1);


        JTextArea textarea1 = new JTextArea(10, 30);
        add(new JScrollPane(textarea1));

        JButton done = new JButton("Done");
        add(done);

        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Student> students = readLines(textarea1.getText());
                    writeStudentsToFile(students, "students.out");
                } catch(Throwable err) {
                    System.err.println(err);

                }
            }
        });
    }

    public static void writeStudentsToFile(ArrayList<Student> students, String file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);

            oos.flush(); // make sure this happens right now
            fos.close(); // close
        }  catch(Throwable e) {
            System.err.println(e);
        }
    }

    private static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
    private static ArrayList<Student> readLines(String lines) throws Exception {
        String[] splitLines = lines.split("\n");
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < splitLines.length; i++) {
            String[] arr = splitLines[i].split("\\s+");

            if (!isParsable(arr[0])) {
                throw new Exception("Wrong id format");
            }
            int stnId = Integer.parseInt(arr[0]);

            ArrayList<String> courses = new ArrayList<>();
            for (int j = 3; j < arr.length; j++) {
                courses.add(arr[j]);
            }
            list.add(new Student(stnId, arr[1], arr[2], courses));
        }
        return list;
    }
}
