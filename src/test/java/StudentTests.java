/*
    StudentTests class

    Padraig Ó Cosgora
    G00311302
    21/02/2020
 */

import static org.junit.jupiter.api.Assertions.*;
import ie.gmit.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.security.InvalidParameterException;

public class StudentTests {

    private Student myStudent;
    private StudentList list;

    @BeforeAll
    @DisplayName("Starting tests")
    public static void print(){
        System.out.println("Starting tests");
    }

    @BeforeEach
    @DisplayName("New instance of Student & StudentList")
    void init(TestInfo testInfo, TestReporter testReporter)
    {
        myStudent = new Student();
        list = new StudentList();
        System.out.println("timestamp = " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Testing Getters and Setters of Student")
    void testGettersAndSetters(TestInfo testInfo)
    {
        myStudent.setEmail("email@email.com");
        assertEquals(myStudent.getEmail(),"email@email.com");
        myStudent.setName("John");
        assertEquals(myStudent.getName(),"John");
    }

    @Test
    @DisplayName("Invalid Email setter test")
    void testEmailInvalid(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myStudent.setEmail("failemail");
        });
    }

    @Test
    @DisplayName("Invalid Name setter Test")
    void testNameInvalid(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myStudent.setName("ze");
        });
    }

    @Test
    @DisplayName("Invalid Constructor Test (invalid name)")
    void testConstructorStudentName(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Student("ze", "ze@gmail.com");
        });
    }

    @Test
    @DisplayName("Invalid Constructor Test (invalid email)")
    void testConstructorStudentEmail(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Student("John", "zegmail.com");
        });
    }

    @Test
    @DisplayName("Valid Constructor test")
    void testConstructorValid(TestInfo testInfo)
    {
        Student student1 = new Student("John", "john@email.com");
        assertEquals("John",student1.getName());
        assertEquals("john@email.com",student1.getEmail());
    }

    @Test
    @DisplayName("Valid ArrayList Entry test")
    void testStudentList(TestInfo testInfo)
    {
        StudentList list = new StudentList();
        Student student1 = new Student("John", "john@email.com");
        list.addStudent(student1);
        assertEquals(student1,list.findByName("John"));
    }

    @Test
    @DisplayName("Invalid ArrayList Entry test")
    void testStudentListInvalid(TestInfo testInfo)
    {
        Student student1 = new Student("John", "john@email.com");
        Student student2 = new Student("John", "john@email.com");
        list.addStudent(student1);
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            list.addStudent(student2);
        });
    }

    @Test
    @DisplayName("Invalid ArrayList Search")
    void testStudentListSearch(TestInfo testInfo)
    {
        Student student1 = new Student("John", "john@email.com");
        list.addStudent(student1);
        assertEquals(null,list.findByName("Paul"));
    }

    @AfterAll
    @DisplayName("Testing complete")
    public static void done(){
        System.out.println("Testing Complete");
    }
}
