package flappyBird;

import graphics.Color;
import graphics.RectangleGraphicElement;
import graphics.SpriteGraphicElement;
import lumenaer.Game;
import lumenaer.Lumenaer;
import lumenaer.PixelMatrix;

public class FlappyBirdGame extends Game {

    Bird bird;
    Pillar[] pillarsDown;
    Pillar[] pillarsUp;
    boolean gameOver = false;
    boolean gameOver2 = false;
    RectangleGraphicElement rect;
    RectangleGraphicElement[] text;
    Skull skull;
    //overlapping the elements, if you change the background, the pillars are still there
    RectangleGraphicElement skullRect;

    public FlappyBirdGame (PixelMatrix matrix) {
        super(matrix);

        text = new RectangleGraphicElement[37];
        //Game Over text
        //G
        text[0] = new RectangleGraphicElement(1,6,4,1, Color.BLACK);
        text[1] = new RectangleGraphicElement(1,6,1,5, Color.BLACK);
        text[2] = new RectangleGraphicElement(1,10,4,1, Color.BLACK);
        text[3] = new RectangleGraphicElement(4,8,1,3, Color.BLACK);
        text[4] = new RectangleGraphicElement(3,8,2,1, Color.BLACK);
        //A
        text[5] = new RectangleGraphicElement(7,6,1,5, Color.BLACK);
        text[6] = new RectangleGraphicElement(7,6,4,1, Color.BLACK);
        text[7] = new RectangleGraphicElement(10,6,1,5, Color.BLACK);
        text[8] = new RectangleGraphicElement(7,9,4,1, Color.BLACK);
        //M
        text[9] = new RectangleGraphicElement(13,6,1,5, Color.BLACK);
        text[10] = new RectangleGraphicElement(17,6,1,5, Color.BLACK);
        text[11] = new RectangleGraphicElement(14,7,1,1, Color.BLACK);
        text[12] = new RectangleGraphicElement(15,8,1,1, Color.BLACK);
        text[13] = new RectangleGraphicElement(16,7,1,1, Color.BLACK);
        //E
        text[14] = new RectangleGraphicElement(19,6,1,5, Color.BLACK);
        text[15] = new RectangleGraphicElement(19,6,4,1, Color.BLACK);
        text[16] = new RectangleGraphicElement(19,8,4,1, Color.BLACK);
        text[17] = new RectangleGraphicElement(19,10,4,1, Color.BLACK);
        //O
        text[18] = new RectangleGraphicElement(1,13,1,5, Color.BLACK);
        text[19] = new RectangleGraphicElement(1,13,4,1, Color.BLACK);
        text[20] = new RectangleGraphicElement(1,17,4,1, Color.BLACK);
        text[21] = new RectangleGraphicElement(4,13,1,5, Color.BLACK);
        //V
        text[22] = new RectangleGraphicElement(7,13,1,2, Color.BLACK);
        text[23] = new RectangleGraphicElement(8,15,1,2, Color.BLACK);
        text[24] = new RectangleGraphicElement(9,17,1,1, Color.BLACK);
        text[25] = new RectangleGraphicElement(10,15,1,2, Color.BLACK);
        text[26] = new RectangleGraphicElement(11,13,1,2, Color.BLACK);
        //E
        text[27] = new RectangleGraphicElement(13,13,4,1, Color.BLACK);
        text[28] = new RectangleGraphicElement(13,13,1,5, Color.BLACK);
        text[29] = new RectangleGraphicElement(13,15,4,1, Color.BLACK);
        text[30] = new RectangleGraphicElement(13,17,4,1, Color.BLACK);
        //R
        text[31] = new RectangleGraphicElement(19,13,4,1, Color.BLACK);
        text[32] = new RectangleGraphicElement(19,13,1,5, Color.BLACK);
        text[33] = new RectangleGraphicElement(22,13,1,3, Color.BLACK);
        text[34] = new RectangleGraphicElement(19,15,4,1, Color.BLACK);
        text[35] = new RectangleGraphicElement(21,16,1,1, Color.BLACK);
        text[36] = new RectangleGraphicElement(22,17,1,1, Color.BLACK);


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
        skullRect = new RectangleGraphicElement(0, 0, pixelMatrix.getWidth(), pixelMatrix.getHeight(), Color.BLACK);
        graphicElements.add(skullRect);
        graphicElements.add(skull);
        rect = new RectangleGraphicElement(0, 0, 12, 12, Color.BLACK);

    }

    @Override
    public void nextGameStep() {

        //hier passiert alles:)
        graphicElements.remove(skullRect);
        graphicElements.remove(skull);

        if (!gameOver) {
            bird.setY(bird.getY() + 1);

            //graphicElements.remove(rect);
            for(int i = 0; i < text.length; i++) {
                graphicElements.remove(text[i]);
            }
            //check for collide with pillars down
            for (Pillar down : pillarsDown) {
                if (bird.intersects(down)) {
                    //bird.setColor(Color.BLACK);
                    System.out.println("hitDown");
                    System.out.println("bird y " + bird.getY());
                    gameOver = true;
                }
            }

            //check for collide with pillars up
            for (Pillar up : pillarsUp) {
                if (bird.intersects(up)) {
                    System.out.println("hitUp");
                    System.out.println("bird y " + bird.getY());
                    gameOver = true;
                }
            }

            if (bird.getY() < 0 || bird.getY()  > pixelMatrix.getHeight()) {
                gameOver = true;
            }

            if (gameOver) {
                graphicElements.add(skullRect);
                graphicElements.add(skull);
                //graphicElements.add(rect);
                for(int i = 0; i < text.length; i++) {
                    graphicElements.add(text[i]);
                }
                bird.setColor(new Color(50,50,50));
            }

        }

        if (gameOver) {
            bird.setY(bird.getY() + 3);

            if (bird.getY() > pixelMatrix.getHeight()+5) {
                gameOver2 = true;
            }
        }

        if (!gameOver2) {
            super.nextGameStep();
        }
    }

    //hier fliegt der vogel
    @Override
    public void buzzered() {
        if (!gameOver) {
            bird.setY(bird.getY() - 5);
        } else if (gameOver && gameOver2) {
            //position des birds und des vogels einfach wieder auf normal setzen
            gameOver = false;
            gameOver2 = false;
            bird.setX(2);
            bird.setY(10);
            bird.setColor(Color.RED);

            for (int i = 0; i < pillarsDown.length; i++) {
                int random = (int) (Math.random() *15);
                System.out.println(random);
                pillarsDown[i].setPillar(30 + i*10, 9 + random, 3, 15, Color.GREEN);
                pillarsUp[i].setPillar(30 + i*10, 0, 3, 1+random, Color.GREEN);
            }
        }
    }


    //brauchen wir warsch auch nicht
    @Override
    public void buzzerReleased() {}

    //haben wir nicht, müssen wir aber überschreiben
    //vielleicht kann man was lustiges machen wie farbe ändern, ist aber nicht wichtig
    @Override
    public void wheelRotation(int rotationValue) {}
}
