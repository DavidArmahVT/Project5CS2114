package prj5;

/**
 * @author David Armah
 * @author Chase Conover
 * @version 2019.11.18
 *
 */
public class SongList extends SinglyLinkedList<Song> {

    /**
     * the SongList constructor
     */
    public SongList() {
        super();
    }


    /**
     * returns song at given index
     * 
     * @return song at given index
     * @param index
     *            The index of the song to get
     */
    public Song getSong(int index) {
        return get(index);
    }


    /**
     * Sorts by artist
     */
    public void sortArtist() {
        sortBy(SortEnums.ARTIST);
    }


    /**
     * Sorts by genre
     */
    public void sortGenre() {
        sortBy(SortEnums.GENRE);
    }


    /**
     * Sorts by title
     */
    public void sortTitle() {
        sortBy(SortEnums.TITLE);
    }


    /**
     * Sorts by year
     */
    public void sortYear() {
        sortBy(SortEnums.YEAR);
    }


    /**
     * Creates a string representation of all the Songs and their data in the
     * list.
     * 
     * @return A string of the data for each Song in the list.
     */
    public String toString() {
        StringBuilder list = new StringBuilder("[");
        int index = 0;

        if (!isEmpty()) {
            while (index < this.size()) {
                list.append(this.get(index).toString());
                if (index != this.size() - 1) {
                    list.append(", ");
                }
                index++;
            }
        }
        list.append("]");
        return list.toString();
    }


    /**
     * Will insert the songs in their correct location
     * 
     * @param sortType
     *            is how to sort the songs in the list
     */
    public void insertInOrder(SortEnums sortType, Node<Song> nodeToInsert) {
        Song insertSong = nodeToInsert.getData();
        Node<Song> currentNode = this.getFirst();
        
        Node<Song> previousNode = null;
        if (sortType == SortEnums.GENRE) {
            CompareByGenre comparer = new CompareByGenre();
            while ((currentNode != null) && (comparer.compare(insertSong,
                currentNode.getData()) > 0)) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }
        }
        else if (sortType == SortEnums.TITLE) {
            CompareByTitle comparer = new CompareByTitle();
            while ((currentNode != null) && (comparer.compare(insertSong, currentNode.getData()) > 0)) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }
        }
        else if (sortType == SortEnums.YEAR) {
            CompareByYear comparer = new CompareByYear();
            while ((currentNode != null) && (comparer.compare(insertSong, currentNode.getData()) > 0)) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }
        }
        else if (sortType == SortEnums.ARTIST || sortType == SortEnums.UNSORTED) {
            CompareByArtist comparer = new CompareByArtist();
            while ((currentNode != null) && (comparer.compare(insertSong, currentNode.getData()) > 0)) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }
        }
        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else {
            nodeToInsert.setNext(this.getFirst());
            this.setFirst(nodeToInsert);
        }

    }


    /**
     * Sorts the song list using the insertion sort algorithim
     * and the insertInOrder Helper Method
     */
    public void sortBy(SortEnums sortType) {
        if ((this.size() > 1)) {
            Node<Song> firstNode = this.getFirst();
            Node<Song> unsortedPart = this.getFirst().next();
            firstNode.setNext(null);

            while (unsortedPart != null) {
                Node<Song> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                this.insertInOrder(sortType, nodeToInsert);
            }

        }
    }

}
