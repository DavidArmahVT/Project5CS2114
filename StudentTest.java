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
    private SinglyLinkedList<String[]> studentList;


    /**
     * sets up fields, creates the student object used in testing
     */
    public void setUp() {
        student = new Student("15", "10/12/17", MajorEnums.CS,
            RegionEnums.OUTSIDE, HobbyEnums.SPORTS, studentList);
    }


    /**
     * tests getters and setters, and constructor
     */
    public void testStudent() {
        assertEquals("10/12/17", student.getDate());
        assertEquals("15", student.getStudentID());
        assertEquals(MajorEnums.CS, student.getMajor());
        assertEquals(RegionEnums.OUTSIDE, student.getRegion());
        assertEquals(HobbyEnums.SPORTS, student.getHobby());
        assertEquals(studentList, student.getResponses());

    }


    /**
     * 
     */
    public void testEquals() {
        Student student2 = new Student("15", "10/12/17", MajorEnums.CS,
            RegionEnums.OUTSIDE, HobbyEnums.SPORTS, studentList);
        assertTrue(student.equals(student2));
    }


    /**
     * 
     */
    public void testEquals1() {
        assertFalse(student.equals(null));
    }


    /**
     * 
     */
    public void testEquals2() {
        String str = "str";
        assertFalse(student.equals(str));

    }


    /**
     * 
     */
    public void testEquals3() {
        Student student2 = new Student("16", "10/12/18", MajorEnums.CS,
            RegionEnums.NE, HobbyEnums.SPORTS, studentList);
        assertFalse(student.equals(student2));

    }

}
