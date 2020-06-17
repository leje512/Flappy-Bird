package flappyBird;

import graphics.Color;
import lumenaer.Game;
import lumenaer.PixelMatrix;

public class FlappyBirdGame extends Game {

    Bird bird;
    Pillar[] pillarsDown;
    Pillar[] pillarsUp;
    boolean gameOver = false;

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

    }

    @Override
    public void nextGameStep() {

        //hier passiert alles:)
        bird.setY(bird.getY() + 1);

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
