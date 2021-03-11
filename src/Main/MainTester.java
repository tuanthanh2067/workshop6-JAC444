package Main;

import Student.ReadStudent;
import Student.WriteStudent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTester extends JFrame {
    private final JButton readStudents;
    private final JButton writeStudents;
    public MainTester() {
        super("Main frame");
        setLayout(new FlowLayout());

        readStudents = new JButton("Read students");
        add(readStudents);

        writeStudents = new JButton("Write students");
        add(writeStudents);

        readStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadStudent read = new ReadStudent();
            }
        });

        writeStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WriteStudent write = new WriteStudent();
            }
        });

    }
    public static void main(String[] args) {
        MainTester main = new MainTester();
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setSize(300, 150);
        main.setVisible(true);
    }
}