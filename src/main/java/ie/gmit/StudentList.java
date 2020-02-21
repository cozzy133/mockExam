package ie.gmit;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class StudentList {

    ArrayList<Student> listOfStudents = new ArrayList<>();

    public void addStudent(Student newStudent) {
        for(Student student : listOfStudents)
            if (student.getName().equals(newStudent.getName()))
                throw new InvalidParameterException("Name already in list");
        listOfStudents.add(newStudent);
    }

    public Student findByName(String name) {
        for(Student student : listOfStudents) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }
}
