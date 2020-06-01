package astroidsGame;

import graphics.Color;
import graphics.RectangleGraphicElement;

public class Wall extends RectangleGraphicElement{

    public Wall(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

   //a wall in the way of the projectile

    public boolean intersects(Projectile projectile) {
        int py = projectile.getY();
        int px = projectile.getX();

        //out of the range
        if (py < y || py > y + getHeight() || px < x || px > x + getWidth()) {
            return false;
        } else {
            return true;
        }
    }

}

