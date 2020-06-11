package flappyBird;

import graphics.Color;
import graphics.SquareGraphicElement;
import lumenaer.Game;
import lumenaer.PixelMatrix;

public class FlappyBirdGame extends Game {

    Bird bird;
    //new pillarlist[5]
    SquareGraphicElement test;
    Pillar pillar;
    Pillar pillar2;
    Pillar pillar3;
    Pillar pillar4;

    public FlappyBirdGame (PixelMatrix matrix) {
        //übernommen von Asteroidsgame
        super(matrix);

        bird = new Bird(2, 10, 2, Color.RED);

        pillar = new Pillar(5, pixelMatrix.getHeight()-8, 2, 8, Color.GREEN);
        pillar2 = new Pillar(5, 0, 2, 8, Color.GREEN);
        pillar3 = new Pillar(10, pixelMatrix.getHeight()-10, 2, 10, Color.GREEN);
        pillar4 = new Pillar(10, 0, 2, 6, Color.GREEN);

        graphicElements.add(bird);

        graphicElements.add(pillar);
        graphicElements.add(pillar2);
        graphicElements.add(pillar3);
        graphicElements.add(pillar4);

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
