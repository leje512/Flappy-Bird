package flappyBird;

import graphics.Color;
import graphics.SquareGraphicElement;
import lumenaer.Game;
import lumenaer.PixelMatrix;

public class FlappyBirdGame extends Game {

    Bird bird;
    //new pillarlist[5]
    SquareGraphicElement test;

    public FlappyBirdGame (PixelMatrix matrix) {
        //übernommen von Asteroidsgame
        super(matrix);

        bird = new Bird(2, 10, 2, Color.RED);
        graphicElements.add(bird);
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
