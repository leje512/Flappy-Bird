package graphics;

public interface Movable {

    /**
     * This function uses the object intrinsic parameters for moving the object
     */
    void move();

    /**
     * this function uses the given parameters for moving the object
     *
     * @param x the amount the object should be moved in x-direction
     * @param y the amount the object should be moved in y-direction
     */
    void move(int x, int y);

}
