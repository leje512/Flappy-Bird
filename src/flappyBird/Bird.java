package flappyBird;

import graphics.Color;
import graphics.SquareGraphicElement;

public class Bird extends SquareGraphicElement {

    public Bird (int x, int y, int radius, Color color) {
        super (x, y, 2, Color.RED);
    }
}
