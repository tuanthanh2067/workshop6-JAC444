package Student;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private int stdId;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses;

    // constructors, getters, setters where appropriate
    Student(int id, String firstName, String lastName, ArrayList<String> courses) {
        this.stdId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = new ArrayList<>(courses);
    }

    public void setStnId(int id) {
        this.stdId = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = new ArrayList<>(courses);
    }

    public int getStnI() {
        return this.stdId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public ArrayList<String> getCourses() {
        return this.courses;
    }
}
