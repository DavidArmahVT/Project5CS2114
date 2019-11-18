// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- David Armah (davida00)
// -- Chase Conover (chase00)

package prj5;

import java.util.LinkedList;

/**
 * Tests Student class
 * 
 * @author David Armah
 * @version 2019.11.17
 *
 */
public class StudentTest extends student.TestCase {
    private Student student;
    private LinkedList<String[]> studentList;


    /**
     * sets up fields, creates the student object used in testing
     */
    public void setUp() {
        student = new Student(15, "10/12/17", MajorEnums.CS,
            RegionEnums.OUTSIDE, HobbyEnums.SPORTS, studentList);
    }


    /**
     * tests getters and setters, and constructor
     */
    public void testStudent() {
        assertEquals("10/12/17", student.getDate());
        assertEquals(15, student.getStudentID());
        assertEquals(MajorEnums.CS, student.getMajor());
        assertEquals(RegionEnums.OUTSIDE, student.getRegion());
        assertEquals(HobbyEnums.SPORTS, student.getHobby());
        assertEquals(studentList, student.getResponses());

    }

}
