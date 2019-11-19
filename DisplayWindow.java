/**
 * 
 */
package prj5;

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

// import java.awt.Window;

/**
 * DisplayWindow
 * 
 * @author David Armah
 * @version 2019.11.18
 *
 */
public class DisplayWindow {
    private Button quit;
    private Button artistSort;
    private Button titleSort;
    private Button yearSort;
    private Button genreSort;
    private Button previous;
    private Button next;
    private Button major;
    private Button region;
    private Button hobby;
    private Window window;
    private int currentPage;

    private SongList songs;
    private SinglyLinkedList<Student> student;

    private double[][][] percentages;

    public static final int SHAPE_BUFFER = 10;

    public static final int TEXT_HEIGHT = 16;

    public static final int TEXT_SPACING = 5;

    public static final int LEGEND_WIDTH = 170;

    public static final int LEGEND_HEIGHT = 8 * TEXT_HEIGHT + 4 * TEXT_SPACING
        + 2 * SHAPE_BUFFER;

/**
 * 
 * @param songs
 * @param student
 */
    public DisplayWindow(SongList songs, SinglyLinkedList<Student> student) {
        this.songs = songs;
        this.student = student;
        window = new Window();
        currentPage = 0;

        Button previous = new Button("Previous");
        previous.onClick(this, "clickedPrevious");
        window.addButton(previous, WindowSide.NORTH);

        Button artistSort = new Button("Sort By Artist Name");
        artistSort.onClick(this, "clickedartistSort");
        window.addButton(artistSort, WindowSide.NORTH);

        Button genreSort = new Button("Sort By Genre");
        genreSort.onClick(this, "clickedgenreSort");
        window.addButton(genreSort, WindowSide.NORTH);

        Button titleSort = new Button("Sort By Title");
        titleSort.onClick(this, "clickedtitleSort");
        window.addButton(titleSort, WindowSide.NORTH);

        Button yearSort = new Button("Sort By Year");
        yearSort.onClick(this, "clickedyearSoty");
        window.addButton(yearSort, WindowSide.NORTH);

        Button next = new Button(" Next ");
        next.onClick(this, "clickedNext");
        window.addButton(next, WindowSide.NORTH);

        Button hobby = new Button("Sort By Hobby");
        hobby.onClick(this, "clickedHobby");
        window.addButton(hobby, WindowSide.SOUTH);

        Button major = new Button("Sort By Major");
        major.onClick(this, "clickedMajor");
        window.addButton(major, WindowSide.SOUTH);

        Button region = new Button("Sort By Region");
        region.onClick(this, "clickedRegion");
        window.addButton(region, WindowSide.SOUTH);

        Button quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.SOUTH);
    }


    public SongList getSongs() {
        return songs;

    }


    public SinglyLinkedList<Student> getStudents() {
        return student;
    }


    public int getPage() {
        return currentPage;
    }


    public void clickedPrevious(Button button) {
        if (currentPage > 0) {
            currentPage--;
            // drawGlyphs();
        }
    }


    /**
     * 
     * @param button
     */
    public void clickedSortArtist(Button button) {
        songs.sortArtist();
        currentPage = 0;
        // drawGlyphs();
    }


    /**
     * 
     * @param button
     */
    public void clickedGenreSort(Button button) {
        songs.sortGenre();
        currentPage = 0;
        // drawGlyphs();
    }


    /**
     * 
     * @param button
     */
    public void clickedSortYear(Button button) {
        songs.sortYear();
        currentPage = 0;
        // drawGlyphs();
    }


    /**
     * 
     * @param button
     */
    public void clickedNext(Button button) {
        if (currentPage < songs.size() / 9) {
            currentPage++;
            // drawGlyphs();
        }
    }


    /**
     * 
     * @param button
     */
    public void clickedHobby(Button button) {

    }

}
