package lumenaer;

import graphics.Color;
import graphics.GraphicObject;

import java.util.ArrayList;

/**
 * Base Class for all games.
 */
public abstract class Game {

    /* A pixel matrix, where to displayPixelMatrix the game.*/
    protected PixelMatrix pixelMatrix; // just for convenience

    /* Array for storing all individual graphic objects to be drawn */
    protected ArrayList<GraphicObject> graphicElements;

    /**
     * Constructor
     *
     * @ param the pixel matrix where the game should be drawn upon
     */
    public Game(PixelMatrix matrix) {
        pixelMatrix = matrix;
        pixelMatrix.setBackgroundColor(Color.WHITE);
        graphicElements = new ArrayList<GraphicObject>();
    }

    /**
     * The next game step. By default, just draws everything.
     * Logic can be extended in the derived classes.
     */
    public void nextGameStep() {

        // set the background
        pixelMatrix.drawBackground();

        //displayPixelMatrix everything
        for (GraphicObject go : graphicElements) {
            go.update();
            go.render(pixelMatrix);
        }

    }

    /**
     * Abstract methods that handle the input from
     * the user interface (wheel and buzzer)
     */
    public abstract void buzzered();

    public abstract void buzzerReleased();

    public abstract void wheelRotation(int rotationValue);


}
