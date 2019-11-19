package prj5;
/**
 * 
 */

/**
 * @author Chase Conover
 * @version 2019.11.17
 *
 */
public class Song {
    private String title;
    private String year;
    private String genre;
    private String artist;
    private int songID;
    
    
    /**
     * creates a new song object
     * @param title is the title of the song
     * @param year is the release year
     * @param genre is the song genre
     * @param artist is the artist of the song
     */
    public Song(String title, String year, String genre, String artist, int songID)
    {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.artist = artist;
        this.songID = songID;
    }
    public int getSongID()
    {
        return songID;
        
    }
    
    /**
     * 
     * @return the title of the song
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * 
     * @return the release year of the song
     */
    public String getYear()
    {
        return year;
    }
    
    /**
     * 
     * @return the genre of the song
     */
    public String getGenre()
    {
        return genre;
    }
    
    /**
     * 
     * @return the artist of the song
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * @return true if the objects are equal
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        else if ( obj == null)
        {
            return false;
        }
        else if(this.getClass() == obj.getClass())
        {
            Song temp = (Song) obj;
            return this.toString().equals(temp.toString());
        }
        return false;
    }
    
    /**
     * @return the Song as a string
     */
    public String toString()
    {
        StringBuilder build = new StringBuilder();
        build.append("Song Title: "+ title);
        build.append("\nSong Artist: " + artist);
        build.append("\nSong Genre: " + genre);
        build.append("\nSong Year: " + year);
        return build.toString();
    }
    

}
