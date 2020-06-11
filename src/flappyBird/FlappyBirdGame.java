package flappyBird;

import graphics.Color;
import graphics.SquareGraphicElement;
import lumenaer.Game;
import lumenaer.PixelMatrix;

public class FlappyBirdGame extends Game {

    Bird bird;
    Pillar[] pillarsDown;
    Pillar[] pillarsUp;
    SquareGraphicElement test;

    public FlappyBirdGame (PixelMatrix matrix) {
        //übernommen von Asteroidsgame
        super(matrix);
        pillarsDown = new Pillar[10];
        pillarsUp = new Pillar[10];
        bird = new Bird(2, 10, 2, Color.RED);

        for (int i = 0; i < pillarsDown.length; i++) {
            int random = (int) (Math.random() *8);
            System.out.println(random);
            pillarsDown[i] = new Pillar(30 + i*8, pixelMatrix.getHeight() -8 + random, 2, 8, Color.GREEN);
            pillarsUp[i] = new Pillar(30 + i*8, 0, 2, 8+random, Color.GREEN);
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

        //check for collide with pillars (how to in MiniAsteroidsGame)

        //next step gets started
        super.nextGameStep();
    }

    //hier fliegt der vogel
    @Override
    public void buzzered() {
        bird.setY(bird.getY() - 5);
    }


    //brauchen wir warsch auch nicht
    @Override
    public void buzzerReleased() {}

    //haben wir nicht, müssen wir aber überschreiben
    //vielleicht kann man was lustiges machen wie farbe ändern, ist aber nicht wichtig
    @Override
    public void wheelRotation(int rotationValue) {}
}
