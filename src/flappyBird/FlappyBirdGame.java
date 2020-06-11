package flappyBird;

import astroidsGame.Projectile;
import graphics.Color;
import graphics.GraphicElement;
import lumenaer.Game;
import lumenaer.PixelMatrix;

import java.util.List;

public class FlappyBirdGame extends Game {

    Pillar pillar;
    Pillar pillar2;
    Pillar pillar3;
    Pillar pillar4;

    public FlappyBirdGame(PixelMatrix m) {
        super(m);

        pillar = new Pillar(5, pixelMatrix.getHeight()-8, 2, 8, Color.GREEN);
        pillar2 = new Pillar(5, 0, 2, 8, Color.GREEN);
        pillar3 = new Pillar(10, pixelMatrix.getHeight()-10, 2, 10, Color.GREEN);
        pillar4 = new Pillar(10, 0, 2, 6, Color.GREEN);

        graphicElements.add(pillar);
        graphicElements.add(pillar2);
        graphicElements.add(pillar3);
        graphicElements.add(pillar4);

        pixelMatrix.setBackgroundColor(new Color(69, 99, 209));

    }







    @Override
    public void buzzered() {

    }

    @Override
    public void buzzerReleased() {
    }

    @Override
    public void wheelRotation(int rotationValue) {
 }
}
