package prj5;

import java.util.Comparator;

/**
 * 
 * @author David Armah
 * @version 2019.11.17
 *
 */
public class CompareByRegion implements Comparator<Student> {
    
    public int compare(Student student1, Student student2)
    {
        return(student1.getRegion().compare(student2.getRegion()));
    }

}
