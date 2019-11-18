/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author David Armah
 * @version 2019.11.19
 *
 */
public class CompareByArtist implements Comparator<Song> {

    /**
     * 
     */
    public int compare(Song song1, Song song2) {
        return song1.getArtist().compareTo(song2.getArtist());
    }

}
