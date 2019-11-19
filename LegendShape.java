package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * Creates and organizes the Shapes in the Legend. Default values stored in
 * DisplayWindow.
 * 
 * @author Chase Conover
 * @version 2018.04.10
 */
public class LegendShape {

    private Window window;
    private TextShape title;
    private TextShape category1;
    private TextShape category2;
    private TextShape category3;
    private TextShape category4;
    private TextShape songTitle;
    private Shape axis;
    private TextShape heardLikedText;
    private Shape background;
    private Shape outline;
    // top-left corner of the legend
    private int x0;
    private int y0;


    /**
     * Constructor for GUILegend. Defaults to Hobby Legend.
     */
    public LegendShape(Window window) {
        this.window = window;

        title = new TextShape(0, 0, "Title");
        title.setBackgroundColor(Color.WHITE);
        category1 = new TextShape(0, 0, "Cat 1", Color.MAGENTA);
        category1.setBackgroundColor(Color.WHITE);
        category2 = new TextShape(0, 0, "Cat 2", Color.BLUE);
        category2.setBackgroundColor(Color.WHITE);
        category3 = new TextShape(0, 0, "Cat 3", Color.ORANGE);
        category3.setBackgroundColor(Color.WHITE);
        category4 = new TextShape(0, 0, "Cat 4", Color.GREEN);
        category4.setBackgroundColor(Color.WHITE);
        songTitle = new TextShape(0, 0, "Song Title");
        songTitle.setBackgroundColor(Color.WHITE);
        axis = new Shape(0, 0, 5, (int)(1.9 * DisplayWindow.TEXT_HEIGHT),
            Color.BLACK);
        heardLikedText = new TextShape(0, 0, "Heard      Likes  "); // trailing
                                                                    // spaces
                                                                    // intentional
        heardLikedText.setBackgroundColor(Color.WHITE);
        background = new Shape(0, 0, DisplayWindow.LEGEND_WIDTH - 2
            * DisplayWindow.SHAPE_BUFFER - 4, DisplayWindow.LEGEND_HEIGHT - 2
                * DisplayWindow.SHAPE_BUFFER - 4, Color.WHITE);
        outline = new Shape(0, 0, DisplayWindow.LEGEND_WIDTH - 2
            * DisplayWindow.SHAPE_BUFFER, DisplayWindow.LEGEND_HEIGHT - 2
                * DisplayWindow.SHAPE_BUFFER, Color.BLACK);
        updateCategory(SortEnums.HOBBY);

        draw();
    }


    /**
     * Draws every Shape in the legend.
     */
    public void draw() {
        x0 = window.getGraphPanelWidth() - DisplayWindow.LEGEND_WIDTH
            + DisplayWindow.SHAPE_BUFFER;
        y0 = window.getGraphPanelHeight() - DisplayWindow.LEGEND_HEIGHT
            + DisplayWindow.SHAPE_BUFFER;

        window.addShape(title);
        moveShape(title, true, 0, 1);
        window.addShape(category1);
        moveShape(category1, false, 1, 2);
        window.addShape(category2);
        moveShape(category2, false, 2, 2);
        window.addShape(category3);
        moveShape(category3, false, 3, 2);
        window.addShape(category4);
        moveShape(category4, false, 4, 2);
        window.addShape(songTitle);
        moveShape(songTitle, true, 5, 3);
        window.addShape(axis);
        moveShape(axis, true, 6, 3);
        window.addShape(heardLikedText);
        moveShape(heardLikedText, true, 6.4, 3);
        window.addShape(background);
        background.moveTo(x0 + 2, y0 + 2);
        window.addShape(outline);
        outline.moveTo(x0, y0);
    }


    /**
     * Helper method for draw().
     * 
     * @param shape
     *            The shape being moved.
     * @param isCentered
     *            True if the shape should be centered in the legend box.
     * @param aboveText
     *            Number of lines of text above the shape.
     * @param aboveSpacing
     *            Number of lines of extra spacing above the shape.
     */
    private void moveShape(
        Shape shape,
        boolean isCentered,
        double aboveText,
        int aboveSpacing) {
        int x;
        int y;
        if (isCentered) {
            x = (int)(x0 + DisplayWindow.LEGEND_WIDTH / 2 - shape.getWidth()
                / 2 - DisplayWindow.SHAPE_BUFFER);
        }
        else {
            x = x0 + DisplayWindow.TEXT_SPACING;
        }
        y = (int)(y0 + aboveText * DisplayWindow.TEXT_HEIGHT + aboveSpacing
            * DisplayWindow.TEXT_SPACING);
        shape.moveTo(x, y);
    }


    /**
     * Updates all the textShapes to reflect the new category, defaults to
     * Hobby.
     * 
     * @param category
     *            The new category.
     */
    public void updateCategory(SortEnums category) {
        switch (category) {
            case HOBBY:
                title.setText("Hobby Legend");
                category1.setText("Read");
                category2.setText("Art");
                category3.setText("Sports");
                category4.setText("Music");
                break;
            case MAJOR:
                title.setText("Major Legend");
                category1.setText("Computer Science");
                category2.setText("Engineering");
                category3.setText("Math/CMDA");
                category4.setText("Other");
                break;
            case REGION:
                title.setText("Region Legend");
                category1.setText("Northeast US");
                category2.setText("Southeast US");
                category3.setText("US (other)");
                category4.setText("Outside of US");
                break;
            default:
                title.setText("Hobby Legend");
                category1.setText("Read");
                category2.setText("Art");
                category3.setText("Sports");
                category4.setText("Music");
        }
    }
}
