package flappyBird;

import flappyBird.Pillar;
import graphics.Color;
import graphics.RectangleGraphicElement;

/**
 * Player character, is controlled by buzzering or mousewheel.
 */

public class Bird extends RectangleGraphicElement {

    /**
     *
     * @param x x-position of the bird
     * @param y y-position of the bird
     * @param width broadth of the rectangle
     * @param height height of the rectangle
     * @param color bodycolor of the bird
     */
    public Bird (int x, int y, int width, int height, Color color) { super (x, y, width, height, color); }

    /**
     * Checks if there is a collision between the bird and a pillar
     * @param pillar the pillar, which gets tested for a collision
     * @return returns true if there is a collision
     */
    public boolean intersects(Pillar pillar) {
        int py = pillar.getY();
        int px = pillar.getX();
        int ph = pillar.getHeight();
        int pw = pillar.getWidth();

        if (x + width +1 > px && x  < px +pw && y + height > py && y +height < py + ph
                || x + width +1 > px && x < px +pw && y > py && y < py + ph) {
            return true;
        } else {
            return false;
        }
    }
}
