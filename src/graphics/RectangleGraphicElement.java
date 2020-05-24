package graphics;

import lumenaer.PixelMatrix;

/**
 * Rectangle Graphics Object
 *
 */
public class RectangleGraphicElement extends GraphicElement {

    int width;
    int height;
    Color color;

    public RectangleGraphicElement(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public RectangleGraphicElement(int x, int y, int width, int height, Color color) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void render(PixelMatrix matrix) {
        for (int i = 0; i< height; ++i) {
            for (int j=0; j<width; ++j) {
                matrix.setPixel(y+i, x+j, color);
            }
        }
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
