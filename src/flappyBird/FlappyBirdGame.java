package flappyBird;

import graphics.Color;
import graphics.RectangleGraphicElement;
import lumenaer.Game;
import lumenaer.Lumenaer;
import lumenaer.PixelMatrix;

public class FlappyBirdGame extends Game {

    Bird bird;
    Pillar[] pillarsDown;
    Pillar[] pillarsUp;
    boolean gameOver = false;
    RectangleGraphicElement rect;

    public FlappyBirdGame (PixelMatrix matrix) {
        super(matrix);
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
        rect = new RectangleGraphicElement(0, 0, 24, 24, Color.BLACK);

    }

    @Override
    public void nextGameStep() {

        //hier passiert alles:)
        bird.setY(bird.getY() + 1);
        graphicElements.remove(rect);

        if (!gameOver) {

            //check for collide with pillars down
            for (Pillar down : pillarsDown) {
                if (bird.intersects(down)) {
                    bird.setColor(Color.BLACK);
                    System.out.println("hitDown");
                    System.out.println("bird y " + bird.getY());
                    gameOver = true;
                }
            }

            //check for collide with pillars up
            for (Pillar up : pillarsUp) {
                if (bird.intersects(up)) {
                    bird.setColor(Color.BLACK);
                    System.out.println("hitUp");
                    System.out.println("bird y " + bird.getY());
                    gameOver = true;
                }
            }

            if (bird.getY() < 0 || bird.getY() > pixelMatrix.getHeight()) {
                gameOver = true;
            }

            if (gameOver) {
                graphicElements.add(rect);
            }
            //next step gets started
            //if (!gameOver) {
            //super.nextGameStep();
            //}
            super.nextGameStep();
        }
    }

    //hier fliegt der vogel
    @Override
    public void buzzered() {
        if (!gameOver) {
            bird.setY(bird.getY() - 5);
        } else {
            //position des birds und des vogels einfach wieder auf normal setzen
            gameOver = false;
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
