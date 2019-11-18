
/**
 * 
 */

/**
 * @author Chase Conover
 * @author David Armah
 * @version 2019.11.17
 *
 */
public class Node<T> {
    private Node<T> next; // links to the next node
    private T data; // first entry


    /**
     * 
     * @param dataPortion
     *            is the data portion to add
     */
    public Node(T dataPortion) {
        this(dataPortion, null);
    }


    /**
     * 
     * @param dataPortion
     *            the data to be stored first
     * @param nextNode
     *            is the nextNode to be referenced
     */
    public Node(T dataPortion, Node<T> nextNode) {
        data = dataPortion;
        next = nextNode;
    }


    /**
     * 
     * @return returns the next node
     */
    public Node<T> getNextNode() {
        return next;
    }


    /**
     * 
     * @return returns the data of type T
     */
    public T getData() {
        return data;
    }


    /**
     * sets the next node
     * 
     * @param nextNode
     *            is the next node to be referenced
     */
    public void setNextNode(Node<T> nextNode) {
        next = nextNode;
    }

}