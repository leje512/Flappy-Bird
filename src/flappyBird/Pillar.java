package flappyBird;

import graphics.Color;
import graphics.RectangleGraphicElement;


/**
 * Class Pillar
 */

public class Pillar extends RectangleGraphicElement {

    public Pillar(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }


    public void update() {
        move();
    }

    public void move() {
        x--;
        if (x < -5) {
            x = 145;
        }
    }
}
