/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author David Armah
 * @version 2019.11.17
 *
 */
public class CompareByTitle implements Comparator<Song> {
    /**
     * 
     */
    public int compare(Song song1, Song song2) {
        return (song1.getTitle().compareTo(song2.getTitle()));
    }

}
