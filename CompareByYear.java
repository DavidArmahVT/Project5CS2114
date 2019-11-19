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
public class CompareByYear implements Comparator<Song> {
/**
 * Compares two songs Years
 */

    @Override
    public int compare(Song song1, Song song2 ) {
       
        return (song1.getYear().compareTo(song2.getYear()));
    }

}
