package astroidsGame;


import graphics.Color;
import graphics.SquareGraphicElement;

public class Projectile extends SquareGraphicElement {

    private int explodingState;
    private boolean destroyed;
    private boolean explode;
    private Color explodingColor;

    public Projectile(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
        setSpeedY(-1); // moves upwards
        explodingState = 0;
        boolean explode = false;
        boolean destroyed = false;
        explodingColor = new Color(255,0,0);
    }

    @Override
    public void update () {

        if (explode && !destroyed) {

            switch (explodingState) {
                case 0:
                    setRadius(0);
                    explodingState++;
                    break;
                case 1:
                    setRadius(2);
                    setColor(explodingColor);
                    explodingState++;
                    break;
                case 2:
                    setRadius(1);
                    setColor(Color.BLUE);
                    explodingState++;
                    break;
                case 3:
                    setRadius(2);
                    setColor(explodingColor);
                    explodingState++;
                    break;
                case 4:
                    setRadius(1);
                    setColor(Color.BLUE);
                    explodingState++;
                    break;
                case 5:
                    explodingState++;
                    destroyed = true;
            }
        } else {
            move();
        }
    }


    public void explode() {
        explode = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }


}
