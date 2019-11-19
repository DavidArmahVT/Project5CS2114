package prj5;

import student.TestCase;

/**
 * 
 */

/**
 * @author Chase Conover
 * @veriosn 2019.11.17
 *
 */
public class SongTest extends TestCase {
    private Song song;
    private Song equals;
    public void setUp()
    {
        song = new Song("B", "2019", "Rap", "Chase");
        equals = new Song("B", "2019", "Rap", "Chase");
    }
    /**
     * tests getters
     */
    public void testGetter()
    {
        assertEquals(song.getArtist(), "Chase");
        assertEquals(song.getGenre(), "Rap");
        assertEquals(song.getTitle(), "B");
        assertEquals(song.getYear(), "2019");
    }
    /**
     * tests equals
     */
    public void testEquals()
    {
        //when the objects are the same
        assertTrue(song.equals(song));
        //when the obj is null
        Song nullSong = null;
        assertFalse(song.equals(nullSong));
        //when the songs are in the same class and =
        assertTrue(song.equals(equals));
        //when obj is in the same class and !=
        Song notEqual = new Song("A", "2017", "Rock", "Joe");
        assertFalse(song.equals(notEqual));
        //when obj is not in the same class
        Object obj = new Object();
        assertFalse(song.equals(obj));
    }
    /**
     * tests toString
     */
    public void testToString()
    {
        assertEquals(song.toString(), "Song Title: B\nSong Artist: Chase\nSong Genre: Rap\nSong Year: 2019");
    }
}
