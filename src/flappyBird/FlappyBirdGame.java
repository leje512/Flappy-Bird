package flappyBird;

import graphics.Color;
import graphics.SquareGraphicElement;
import lumenaer.Game;
import lumenaer.PixelMatrix;

public class FlappyBirdGame extends Game {

    //new bird;
    //new pillarlist[5]
    SquareGraphicElement test;

    public FlappyBirdGame (PixelMatrix matrix) {
        //übernommen von Asteroidsgame
        super(matrix);

        test = new SquareGraphicElement(3, 4, 2, Color.GREEN);
        graphicElements.add(test);
    }

    @Override
    public void nextGameStep() {
        //hier passiert alles:)
        super.nextGameStep();
    }

    //hier fliegt der vogel
    @Override
    public void buzzered() { }


    //brauchen wir warsch auch nicht
    @Override
    public void buzzerReleased() {}

    //haben wir nicht, müssen wir aber überschreiben
    //vielleicht kann man was lustiges machen wie farbe änder, ist aber nicht wichtig
    @Override
    public void wheelRotation(int rotationValue) {}
}
