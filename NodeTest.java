import student.TestCase;

/**
 * 
 */

/**
 * @author Chase Conover
 * @author David Armah
 * @version 2019.11.17
 *
 */
public class NodeTest extends TestCase {

    private Node<String> n;
    private Node<String> n2;


    /**
     * sets up the test class
     */
    public void setUp() {
        n = new Node<>("lol");
        n2 = new Node<>("node", n);
    }


    /**
     * test get next node for all possibilities
     */
    public void testGetNextNode() {
        assertEquals(n.getNextNode(), null);
        assertEquals(n2.getNextNode(), n);
    }


    /**
     * test get data
     */
    public void testGetData() {
        assertEquals(n2.getData(), "node");
        assertEquals(n.getData(), "lol");
    }


    /**
     * test set next node
     */
    public void testSetNextNode() {
        Node<String> n3 = new Node<>("Ha");
        n.setNextNode(n3);
        assertEquals(n.getNextNode(), n3);
    }

}