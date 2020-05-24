package astroidsGame;

import graphics.Color;
import graphics.RectangleGraphicElement;

public class Bar extends RectangleGraphicElement {

    public Bar(int width, int height, Color color, int maxPos) {
        this(0,0, width, height, color);
    }

    public Bar(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }


}
