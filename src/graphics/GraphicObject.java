package graphics;

import lumenaer.PixelMatrix;

/**
 * The class representing Generic Graphic Objects (i.e. Objects that can be displayed/rendered on a
 * PixelMatrix. The PixelMatrix reference gets passed into the render-Method of the class.
 *
 */
public abstract class GraphicObject {

    protected int x;
    protected int y;

    /**
     * Default constructor. Places the x/y coordinates of the GraphicsObject at (0|0).
     */
    public GraphicObject() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor that creates a GraphicObjects at position x/y.
     *
     * @param x the x coordinate of the GraphicObject
     * @param y the y coordinate of the GraphicObject
     */
    public GraphicObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method in which the internal parameters of the GraphicObject (i.e. position or any other parameters that are
     * introduced by derived classes to define a shape) can be updated. The next rendering step (render) can then be
     * be based on these new internal parameters.
     */
    public void update() {}

    /**
     * Method to transfer the pixels (graphic representation) of GraphicObject
     * the to PixelMatrix (i.e. the lumenaer Screen)
     *
     * @param matrix the pixel Matrix
     */
    public abstract void render(PixelMatrix matrix);

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
