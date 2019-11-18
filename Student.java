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
 * Class represents one individual student.
 * 
 * @author David Armah
 * @version 2019.11.17
 *
 */
public class Student {
    private int studentID;
    private String date;
    private MajorEnums major;
    private RegionEnums region;
    private HobbyEnums hobby;
    private LinkedList<String[]> students;


    /**
     * Initializes fields
     * Constructor for a single student
     */
    public Student(
        int studentID,
        String date,
        MajorEnums major,
        RegionEnums region,
        HobbyEnums hobby,
        LinkedList<String[]> students) {
        this.studentID = studentID;
        this.date = date;
        this.major = major;
        this.region = region;
        this.hobby = hobby;
        this.students = students;
    }


    /**
     * 
     * @return
     */
    public int getStudentID() {
        return studentID;
    }


    /**
     * 
     * @return
     */
    public String getDate() {
        return date;
    }


    /**
     * Returns such students Major
     * 
     * @return major
     */
    public MajorEnums getMajor() {
        return major;
    }


    /**
     * Returns such students region
     * 
     * @return region
     */
    public RegionEnums getRegion() {
        return region;
    }


    /**
     * Returns such students favorite hobby
     * 
     * @return hobby
     */
    public HobbyEnums getHobby() {
        return hobby;
    }


    /**
     * Two students are equal if they are from the same region,
     * have the same major, and have the same favorite hobby
     * 
     * @param obj
     *            obj being compared
     * @return if such students are equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            Student student = (Student)obj;
            return student.getMajor().equals(this.getMajor()) && student
                .getRegion().equals(this.getRegion()) && student.getHobby()
                    .equals(this.getHobby());

        }
        return false;
    }


    /**
     * return responses
     * 
     * @return responses
     */
    public LinkedList<String[]> getResponses() {
        return students;
    }

}
