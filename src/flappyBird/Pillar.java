package flappyBird;

import graphics.Color;
import graphics.RectangleGraphicElement;


/**
 * creates obstacles for the bird
 */

public class Pillar extends RectangleGraphicElement {

    public Pillar(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    /**
     *
     * @param x x-position of pillar
     * @param y y-position of pillar
     * @param width width of pillar
     * @param height height of pillar
     * @param color color of pillar
     */
    public void setPillar(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public void update() {
        move();
    }

    /**
     * moves the Pillars from right to left
     * resets the Pillar if X-Position < 5
     */
    public void move() {
        x--;
        if (x < -5) {
            x = 145;
        }
    }
}
