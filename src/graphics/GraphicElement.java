package graphics;

import lumenaer.PixelMatrix;

/**
 * The class representing Generic Graphic Elements (i.e. Objects that can be displayed/rendered on a
 * PixelMatrix. The PixelMatrix reference gets passed into the render-Method of the class.
 *
 */
public abstract class GraphicElement implements Movable {

    protected int x;
    protected int y;

    protected int speedX;
    protected int speedY;

    protected Color color;

    /**
     * Default constructor. Places the x/y coordinates of the GraphicElement at (0|0). The default color is black.
     */
    public GraphicElement() {
      this(0,0);
    }

    /**
     * Constructor that creates a GraphicElement at position x/y. The default color is black.
     *
     * @param x the x coordinate of the GraphicElement
     * @param y the y coordinate of the GraphicElement
     */
    public GraphicElement(int x, int y) {
        this(x,y,0,0,Color.BLACK);
    }

    /**
     * Constructor that creates a GraphicElement at position x/y and a given color.
     *
     * @param x the x coordinate of the GraphicElement
     * @param y the y coordinate of the GraphicElement
     */
    public GraphicElement(int x, int y, Color color) {
        this(x,y,0,0,color);
    }

    /**
     * Constructor that creates a GraphicElement at position x/y and with a predefined speed.
     *
     * @param x the x coordinate of the GraphicElement
     * @param y the y coordinate of the GraphicElement
     * @param speedX the speed of the GraphicElement in x-direction
     * @param speedY the speed of the GraphicElement in y-direction
     * @param color the color of the GraphicElement (eventually the background color)
     */
    public GraphicElement(int x, int y, int speedX, int speedY, Color color) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.color = color;
    }

    /**
     * Method in which the internal parameters of the GraphicElement (i.e. position or any other parameters that are
     * introduced by derived classes to define a shape) can be updated. The next rendering step (render) can then be
     * be based on these new internal parameters.
     */
    public void update() {}

    /**
     * Method to transfer the pixels (graphic representation) of GraphicElement
     * the to PixelMatrix (i.e. the lumenaer Screen)
     *
     * @param matrix the pixel Matrix
     */
    public abstract void render(PixelMatrix matrix);

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
        this.x = x; // just set the x/y coordinates to the desired values
        this.y = y;
    }

    @Override
    public void move() {
        this.x += speedX;
        this.y += speedY;
    }

    // Get- and Set- Methods --------------------------------

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

    public int getSpeedX() {
        return speedX;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
