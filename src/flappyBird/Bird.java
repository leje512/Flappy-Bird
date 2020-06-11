package flappyBird;

import flappyBird.Pillar;
import graphics.Color;
import graphics.SquareGraphicElement;

public class Bird extends SquareGraphicElement {

    public Bird (int x, int y, int radius, Color color) {
        super (x, y, radius, color);
    }

    public boolean intersects(Pillar pillar) {
        //TODO: auskommentieren, sobald es die Methoden gibt
        /*int py = pillar.getY();
        int px = pillar.getX();

        //out of the range
        if (py < y || py > y + getHeight() || px < x || px > x + getWidth()) {
            return false;
        } else {
            return true;
        }
        */
        return false;
    }
}
