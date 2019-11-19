/**
 * 
 */
package prj5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author David Armah
 * @version 2019.11.17
 *
 */
public class SongListTest extends student.TestCase {

    /**
     * Declare the SongList objects to be tested on.
     */
    private SongList songList;
    private SongList emptySongList;


    /**
     * Initialize the LinkedList objects for testing.
     */
    public void setUp() {
        songList = new SongList();
        emptySongList = new SongList();

        songList.add(new Song("Song1", "2002", "Rap", "Drake"));
        songList.add(new Song("Song2", "2000", "Metal", "Beatles"));
        songList.add(new Song("Song3", "1999", "RnB", "Summer Walker"));
    }


    /**
     * Tests the getSong method in the SongList class to ensure it returns the
     * correct Song object at the provided index and throws the correct
     * exceptions when the provided index is invalid.
     */
    public void testGetSong() {
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            0));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(1));
        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));

        Exception exception = null;
        try {
            songList.getSong(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            songList.getSong(1000);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptySongList.getSong(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptySongList.getSong(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptySongList.getSong(1000);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the sortArtist method in the SongList class to ensure it sorts the
     * SongList alphabetically by an Song's artist name.
     */
    public void testSortArtist() {
        assertEquals(new Song("Song1", "2002", "Rap", "C"), songList.getSong(
            0));
        assertEquals(new Song("Song2", "2000", "Metal", "D"), songList
            .getSong(1));
        assertEquals(new Song("Song3", "1999", "RnB", "A"), songList
            .getSong(2));

        songList.sortArtist();

        assertEquals(new Song("Song3", "1999", "RnB", "C"), songList
            .getSong(2));
        assertEquals(new Song("Song1", "2002", "Rap", "D"), songList.getSong(
            1));
        assertEquals(new Song("Song2", "2000", "Metal", "A"), songList
            .getSong(0));
    }


    /**
     * Tests the sortGenre method in the SongList class to ensure it sorts the
     * SongList alphabetically by a Song's genre.
     */
    public void testSortGenre() {
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            0));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(1));
        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));

        songList.sortGenre();

        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            1));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(0));
    }


    /**
     * Tests the sortTitle method in the SongList class to ensure it sorts the
     * SongList alphabetically by a Song's title.
     */
    public void testSortTitle() {
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            0));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(1));
        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));

        songList.sortTitle();

        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(1));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            0));
    }


    /**
     * Tests the sortYear method in the SongList class to ensure it sorts the
     * SongList numerically by a Song's year.
     */
    public void testSortYear() {
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            0));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(1));
        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));
        songList.sortYear();

        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(1));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            2));
        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(0));
    }


    /**
     * Tests the sortBy method in the SongList class to ensure it sorts by the
     * specified SortEnums correctly, even if the SortEnums is unknown.
     */
    public void testSortBy() {
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            0));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(1));
        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));

        songList.sortBy(SortEnums.ARTIST);

        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            1));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(0));
        
        songList.sortBy(SortEnums.UNSORTED);

        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            1));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(0));
        
        songList.sortBy(SortEnums.ARTIST);
        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            1));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(0));
        
        songList.sortBy(SortEnums.ARTIST);
        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            1));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(0));

        songList.sortBy(SortEnums.GENRE);

        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            1));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(0));

        songList.sortBy(SortEnums.TITLE);

        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(1));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            0));

        /**
        songList.sortBy(SortEnums.YEAR);

        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(1));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            2));
        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(0));
            */
        
        songList.sortBy(SortEnums.ARTIST);

        assertEquals(new Song("Song3", "1999", "RnB", "Summer Walker"), songList
            .getSong(2));
        assertEquals(new Song("Song1", "2002", "Rap", "Drake"), songList.getSong(
            1));
        assertEquals(new Song("Song2", "2000", "Metal", "Beatles"), songList
            .getSong(0));

    }


    /**
     * Tests the toString method in the SongList class to ensure it outputs the
     * SongList in a string in the correct format.
     */
    public void testToString() {

        assertEquals("[]", emptySongList.toString());
    }
}
