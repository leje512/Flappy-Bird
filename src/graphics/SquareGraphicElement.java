package graphics;

import lumenaer.PixelMatrix;

public class SquareGraphicElement extends GraphicElement {

    protected int radius;

    public SquareGraphicElement(int x, int y, int radius, Color color) {
        super(x, y);
        this.radius = radius;
        this.color = color;
    }

    public void render(PixelMatrix matrix) {
        int drawRadius = radius -1;
        for (int i = -drawRadius; i <= drawRadius; ++i) {
            for (int j=-drawRadius; j<= drawRadius; ++j) { //TODO: -drawRadius
                matrix.setPixel(y+i, x+j, color);
            }
        }
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
