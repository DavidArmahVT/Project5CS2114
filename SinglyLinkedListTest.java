package prj5;

import student.TestCase;

/**
 * @author Chase Conover
 * @version 1
 *
 */
public class SinglyLinkedListTest extends TestCase {

    private SinglyLinkedList<String> list1;


    /**
     * te
     */
    public void setUp() {
        list1 = new SinglyLinkedList<String>();
    }


    /**
     * te
     */
    public void testSize() {
        assertEquals(list1.size(), 0);
    }


    /**
     * te
     */
    public void testAddAtIndex() {
        // when the element to be added is null
        String nullString = null;
        Exception e = null;
        try {
            list1.add(0, nullString);
        }
        catch (IllegalArgumentException ex) {
            e = ex;
        }
        assertNotNull(e);
        e = null;
        // when index < 0
        try {
            list1.add(-1, "Joe");
        }
        catch (IndexOutOfBoundsException ex) {
            e = ex;
        }
        assertNotNull(e);
        // when index > size
        e = null;
        try {
            list1.add(2, "Joey");
        }
        catch (IndexOutOfBoundsException ex) {
            e = ex;
        }
        assertNotNull(e);
        // when the list is empty
        assertEquals(list1.size(), 0);
        list1.add(0, "Joe");
        assertEquals(list1.size(), 1);
        // else
        list1.add(0, "bob");
        assertEquals(list1.size(), 2);
        assertEquals(list1.get(0), "bob");
        assertEquals(list1.get(1), "Joe");
        list1.add(1, "Fail");
        assertEquals(list1.get(1), "Fail");
        assertEquals(list1.get(0), "bob");
        assertEquals(list1.get(2), "Joe");

    }


    /**
     * te
     */
    // clear remove add and remove
    public void testAdd() {
        // when the element to be added is null
        String nullString = null;
        Exception e = null;
        try {
            list1.add(nullString);
        }
        catch (IllegalArgumentException ex) {
            e = ex;
        }
        assertNotNull(e);
        // when the list isEmpty
        list1.add("Joey");
        assertEquals(list1.size(), 1);
        assertEquals(list1.get(0), "Joey");
        // when the list isNotEmpty
        list1.add("Lauren");
        assertEquals(list1.size(), 2);
        assertEquals(list1.get(1), "Lauren");

    }


    /**
     * te
     */
    public void testIsEmpty() {
        assertEquals(list1.isEmpty(), true);
        list1.add("Joe");
        assertEquals(list1.isEmpty(), false);
    }


    /**
     * te
     */
    public void testRemoveObject() {
        list1.add("Joe");
        // case 1, when head is not null
        assertEquals(list1.remove("Joe"), true);
        assertEquals(list1.size(), 0);
        // case 1, when the size is 1 and data is not there
        list1.add("Joe");
        assertEquals(list1.remove("Bob"), false);
        // case 1 when head is null
        list1.remove("Joe");
        assertEquals(list1.remove("Bob"), false);
        // Case 2, when size >= 2 && current.next!=null
        list1.add("Joe");
        list1.add("Bob");
        list1.add("Hans");
        list1.remove("Bob");
        assertEquals(list1.get(0), "Joe");
        assertEquals(list1.get(1), "Hans");
        // Case 2, when size >=2 but the item is not found
        assertEquals(list1.remove("Hal"), false);
    }


    /**
     * te
     */
    public void testRemoveIndex() {
        // when head == null
        Exception e = null;
        try {
            list1.remove(0);
        }
        catch (IndexOutOfBoundsException ex) {
            e = ex;
        }
        assertNotNull(e);
        // when index < 0
        e = null;
        try {
            list1.remove(-1);
        }
        catch (IndexOutOfBoundsException ex) {
            e = ex;
        }
        assertNotNull(e);
        // when the index is 0
        list1.add("Joe");
        assertEquals(list1.remove(0), true);
        list1.add("Bob");
        list1.add("Chase");
        list1.add("H");
        list1.add("J");
        assertEquals(list1.remove(3), true);
        assertEquals(list1.size(), 3);
        assertEquals(list1.get(0), "Bob");
        e = null;
        try {
            list1.remove(8);
        }
        catch (IndexOutOfBoundsException ex) {
            e = ex;
        }
        assertNotNull(e);
    }


    /**
     * te
     */
    public void testContains() {
        assertEquals(list1.contains("Chase"), false);
        list1.add("Chase");
        assertEquals(list1.contains("Chase"), true);
        list1.add("Joe");
        assertEquals(list1.contains("Joe"), true);
        assertEquals(list1.contains("Paul"), false);
    }


    /**
     * te
     */
    public void testClear() {
        list1.clear();
        assertEquals(list1.size(), 0);
        list1.add("A");
        list1.add("C");
        list1.clear();
        assertEquals(list1.size(), 0);
        // last index of
        list1.add("D");
        list1.add("D");
        assertEquals(list1.lastIndexOf("D"), 1);
        list1.add("C");
        list1.add("D");
        assertEquals(list1.lastIndexOf("D"), 3);
        // to string
        assertEquals(list1.toString(), "{D, D, C, D}");
        list1.clear();
        assertEquals(list1.toString(), "{}");
        // tests get
        Exception e = null;
        try {
            list1.get(5);
        }
        catch (IndexOutOfBoundsException ex) {
            e = ex;
        }
        assertNotNull(e);
    }

}
