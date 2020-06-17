package flappyBird;

import flappyBird.Pillar;
import graphics.Color;
import graphics.RectangleGraphicElement;

public class Bird extends RectangleGraphicElement {

    public Bird (int x, int y, int width, int height, Color color) { super (x, y, width, height, color); }

    public boolean intersects(Pillar pillar) {
        int py = pillar.getY();
        int px = pillar.getX();
        int ph = pillar.getHeight();
        int pw = pillar.getWidth();

        //this doesn't work yet, there are issues with the y position of the bird
        /*if ( y < py + ph && y + getHeight() -1 > py ) {
            if ( x + getWidth() -1 >= px && x <= px + pw) {
                System.out.println("x: " + x + " y " + y + " px " + px + " py " + py + " ph " + ph + " pw " + pw);
                return true;
            }
            return false;
        } else {
            return false;
        }*/

        if (x + width +1 > px && x  < px +pw && y + height > py && y +height < py + ph
                || x + width +1 > px && x < px +pw && y > py && y < py + ph) {
            return true;
        } else {
            return false;
        }
    }
}
