package flappyBird;

import graphics.Color;
import graphics.RectangleGraphicElement;
import lumenaer.Game;
import lumenaer.PixelMatrix;

/**
 * where the game physics are programmed
 */
public class FlappyBirdGame extends Game {

    int colorCounter = 0;
    Bird bird;
    Pillar[] pillarsDown;
    Pillar[] pillarsUp;
    boolean collide = false;
    boolean gameOver = false;
    boolean drawnOneTime = false;
    RectangleGraphicElement rect;
    RectangleGraphicElement[] text;
    Skull skull;
    //overlapping the elements, if you change the background, the pillars are still there

    /**
     * the game elements are initialised. there is the bird and pillars.
     * the player is in control of the bird.
     *
     * the game over screen is also initialised here as a skull and as text.
     * @param matrix matrix for the lumenaer graphic
     */
    public FlappyBirdGame (PixelMatrix matrix) {
        super(matrix);

        text = new RectangleGraphicElement[37];
        //Game Over text
        {
        //G
            text[0] = new RectangleGraphicElement(1, 6, 4, 1, Color.BLACK);
            text[1] = new RectangleGraphicElement(1, 6, 1, 5, Color.BLACK);
            text[2] = new RectangleGraphicElement(1, 10, 4, 1, Color.BLACK);
            text[3] = new RectangleGraphicElement(4, 8, 1, 3, Color.BLACK);
            text[4] = new RectangleGraphicElement(3, 8, 2, 1, Color.BLACK);
            //A
            text[5] = new RectangleGraphicElement(7, 6, 1, 5, Color.BLACK);
            text[6] = new RectangleGraphicElement(7, 6, 4, 1, Color.BLACK);
            text[7] = new RectangleGraphicElement(10, 6, 1, 5, Color.BLACK);
            text[8] = new RectangleGraphicElement(7, 9, 4, 1, Color.BLACK);
            //M
            text[9] = new RectangleGraphicElement(13, 6, 1, 5, Color.BLACK);
            text[10] = new RectangleGraphicElement(17, 6, 1, 5, Color.BLACK);
            text[11] = new RectangleGraphicElement(14, 7, 1, 1, Color.BLACK);
            text[12] = new RectangleGraphicElement(15, 8, 1, 1, Color.BLACK);
            text[13] = new RectangleGraphicElement(16, 7, 1, 1, Color.BLACK);
            //E
            text[14] = new RectangleGraphicElement(19, 6, 1, 5, Color.BLACK);
            text[15] = new RectangleGraphicElement(19, 6, 4, 1, Color.BLACK);
            text[16] = new RectangleGraphicElement(19, 8, 4, 1, Color.BLACK);
            text[17] = new RectangleGraphicElement(19, 10, 4, 1, Color.BLACK);
            //O
            text[18] = new RectangleGraphicElement(1, 13, 1, 5, Color.BLACK);
            text[19] = new RectangleGraphicElement(1, 13, 4, 1, Color.BLACK);
            text[20] = new RectangleGraphicElement(1, 17, 4, 1, Color.BLACK);
            text[21] = new RectangleGraphicElement(4, 13, 1, 5, Color.BLACK);
            //V
            text[22] = new RectangleGraphicElement(7, 13, 1, 2, Color.BLACK);
            text[23] = new RectangleGraphicElement(8, 15, 1, 2, Color.BLACK);
            text[24] = new RectangleGraphicElement(9, 17, 1, 1, Color.BLACK);
            text[25] = new RectangleGraphicElement(10, 15, 1, 2, Color.BLACK);
            text[26] = new RectangleGraphicElement(11, 13, 1, 2, Color.BLACK);
            //E
            text[27] = new RectangleGraphicElement(13, 13, 4, 1, Color.BLACK);
            text[28] = new RectangleGraphicElement(13, 13, 1, 5, Color.BLACK);
            text[29] = new RectangleGraphicElement(13, 15, 4, 1, Color.BLACK);
            text[30] = new RectangleGraphicElement(13, 17, 4, 1, Color.BLACK);
            //R
            text[31] = new RectangleGraphicElement(19, 13, 4, 1, Color.BLACK);
            text[32] = new RectangleGraphicElement(19, 13, 1, 5, Color.BLACK);
            text[33] = new RectangleGraphicElement(22, 13, 1, 3, Color.BLACK);
            text[34] = new RectangleGraphicElement(19, 15, 4, 1, Color.BLACK);
            text[35] = new RectangleGraphicElement(21, 16, 1, 1, Color.BLACK);
            text[36] = new RectangleGraphicElement(22, 17, 1, 1, Color.BLACK);
        }

        pillarsDown = new Pillar[15];
        pillarsUp = new Pillar[15];
        bird = new Bird(2, 10, 2, 2, Color.RED);
        System.out.println("bird y " + bird.getY());

        for (int i = 0; i < pillarsDown.length; i++) {
            int random = (int) (Math.random() *15);
            System.out.println(random);
            pillarsDown[i] = new Pillar(30 + i*10, 9 + random, 3, 15, Color.GREEN);
            pillarsUp[i] = new Pillar(30 + i*10, 0, 3, 1+random, Color.GREEN);
        }


        graphicElements.add(bird);

        for (int i = 0; i < pillarsDown.length; i++) {
            graphicElements.add(pillarsDown[i]);
            graphicElements.add(pillarsUp[i]);
        }

        pixelMatrix.setBackgroundColor(new Color(69, 99, 209));
        skull = new Skull(4, 4);

    }

    /**
     * recursive programming of a single game-step.
     * moves the bird downwards and checks for collision, as well as triggers the game-over-screen
     */
    @Override
    public void nextGameStep() {

        if (!collide) {
            //move bird down every game step
            bird.setY(bird.getY() + 1);

            //remove game over text
            for(int i = 0; i < text.length; i++) {
                graphicElements.remove(text[i]);
            }
            //check for collide with pillars down
            for (Pillar down : pillarsDown) {
                if (bird.intersects(down)) {
                    System.out.println("hitDown");
                    System.out.println("bird y " + bird.getY());
                    collide = true;
                }
            }

            //check for collide with pillars up
            for (Pillar up : pillarsUp) {
                if (bird.intersects(up)) {
                    System.out.println("hitUp");
                    System.out.println("bird y " + bird.getY());
                    collide = true;
                }
            }
            //check for collide with borders of matrix
            if (bird.getY() < 0 || bird.getY()  > pixelMatrix.getHeight()) {
                collide = true;
            }
            // trigger game over image and change bird color when pillar is hit
            if (collide) {

                graphicElements.add(skull);

                bird.setColor(new Color(50,50,50));
            }

        }

        if (collide) {
            bird.setY(bird.getY() + 3);
            //remove game over image
            if (bird.getY() > pixelMatrix.getHeight()) {
                graphicElements.remove(skull);
            }
            // trigger game over text
            if (bird.getY() > pixelMatrix.getHeight() && !drawnOneTime) {
                for(int i = 0; i < text.length; i++) {
                    graphicElements.add(text[i]);
                }
                drawnOneTime = true;
            }

            if (bird.getY() > pixelMatrix.getHeight()+5) {
                gameOver = true;
            }
        }
        //game stops if game over
        if (!gameOver) {
            super.nextGameStep();
        }
    }

    /**
     * moves the bird up for every click
     * restarts the game if game over
     */
    @Override
    public void buzzered() {
        if (!collide) {
            bird.setY(bird.getY() - 5);
        } else if (collide && gameOver) {
            //resets the position of the bird to his starting point
            collide = false;
            gameOver = false;
            drawnOneTime = false;
            bird.setX(2);
            bird.setY(10);
            bird.setColor(Color.RED);
            //resets the pillars every new game (random gap)
            for (int i = 0; i < pillarsDown.length; i++) {
                int random = (int) (Math.random() *15);
                System.out.println(random);
                pillarsDown[i].setPillar(30 + i*10, 9 + random, 3, 15, Color.GREEN);
                pillarsUp[i].setPillar(30 + i*10, 0, 3, 1+random, Color.GREEN);
            }
        }
    }


    @Override
    public void buzzerReleased() {}

    /**
     * Changes the color of the bird
     * @param rotationValue Value of the mouse wheel
     */
    @Override
    public void wheelRotation(int rotationValue) {
        if (!collide) {
            colorCounter += rotationValue;
            if (colorCounter >= 0) {
                bird.setColor(Color.RED);
            }
            if (colorCounter >= 4) {
                bird.setColor(Color.YELLOW);
            }
            if (colorCounter >= 8) {
                bird.setColor(Color.BLUE);
            }
            if (colorCounter >= 12) {
                bird.setColor(Color.WHITE);
            }
            if (colorCounter >= 16) {
                bird.setColor(Color.MAGENTA);
            }
            if (colorCounter >= 20) {
                colorCounter = 0;
            }
            if (colorCounter < -4) {
                colorCounter = 20;
            }
        }
    }
}
