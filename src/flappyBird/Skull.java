package flappyBird;

import graphics.Color;
import graphics.SpriteGraphicElement;

public class Skull extends SpriteGraphicElement {

    public Skull (int posX, int posY){
        super(posX, posY);
        sprite = new Color[17][16]; // sprite matrix must be created here

        //background
        for (int i = 0; i < sprite.length; i++) {
            for (int j = 0; j < sprite[i].length; j++) {
                sprite[i][j] = Color.TRANSPARENT;
            }
        }
        //upper head
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < sprite[i].length; j++) {
                sprite[i][j] = Color.WHITE;
            }
        }

        //headform
        sprite[0][0] = Color.TRANSPARENT;
        sprite[0][1] = Color.TRANSPARENT;
        sprite[0][2] = Color.TRANSPARENT;
        sprite[1][0] = Color.TRANSPARENT;
        sprite[1][0] = Color.TRANSPARENT;
        sprite[2][0] = Color.TRANSPARENT;

        sprite[0][13] = Color.TRANSPARENT;
        sprite[0][14] = Color.TRANSPARENT;
        sprite[0][15] = Color.TRANSPARENT;
        sprite[1][14] = Color.TRANSPARENT;
        sprite[1][15] = Color.TRANSPARENT;
        sprite[2][15] = Color.TRANSPARENT;

        //Eyes
        sprite[4][4] = Color.BLACK;
        sprite[4][11] = Color.BLACK;
        sprite[5][3] = Color.BLACK;
        sprite[5][4] = Color.BLACK;
        sprite[5][5] = Color.BLACK;
        sprite[5][10] = Color.BLACK;
        sprite[5][11] = Color.BLACK;
        sprite[5][12] = Color.BLACK;
        sprite[6][3] = Color.BLACK;
        sprite[6][4] = Color.BLACK;
        sprite[6][5] = Color.BLACK;
        sprite[6][10] = Color.BLACK;
        sprite[6][11] = Color.BLACK;
        sprite[6][12] = Color.BLACK;
        sprite[7][4] = Color.BLACK;
        sprite[7][11] = Color.BLACK;

        //nose
        sprite[9][7] = Color.BLACK;
        sprite[9][8] = Color.BLACK;
        sprite[10][6] = Color.BLACK;
        sprite[10][7] = Color.BLACK;
        sprite[10][8] = Color.BLACK;
        sprite[10][9] = Color.BLACK;

        //head next to nose
        sprite[9][2] = Color.WHITE;
        sprite[9][3] = Color.WHITE;
        sprite[9][4] = Color.WHITE;
        sprite[9][5] = Color.WHITE;
        sprite[9][6] = Color.WHITE;
        sprite[9][9] = Color.WHITE;
        sprite[9][10] = Color.WHITE;
        sprite[9][11] = Color.WHITE;
        sprite[9][12] = Color.WHITE;
        sprite[9][13] = Color.WHITE;
        sprite[10][3] = Color.WHITE;
        sprite[10][4] = Color.WHITE;
        sprite[10][5] = Color.WHITE;
        sprite[10][10] = Color.WHITE;
        sprite[10][11] = Color.WHITE;
        sprite[10][12] = Color.WHITE;

        sprite[11][4] = Color.WHITE;
        sprite[11][5] = Color.WHITE;
        sprite[11][6] = Color.WHITE;
        sprite[11][7] = Color.WHITE;
        sprite[11][8] = Color.WHITE;
        sprite[11][9] = Color.WHITE;
        sprite[11][10] = Color.WHITE;
        sprite[11][11] = Color.WHITE;
        sprite[12][4] = Color.WHITE;
        sprite[12][5] = Color.WHITE;
        sprite[12][6] = Color.WHITE;
        sprite[12][7] = Color.WHITE;
        sprite[12][8] = Color.WHITE;
        sprite[12][9] = Color.WHITE;
        sprite[12][10] = Color.WHITE;
        sprite[12][11] = Color.WHITE;

        //13 is gap
        sprite[13][4] = Color.BLACK;
        sprite[13][6] = Color.BLACK;
        sprite[13][7] = Color.BLACK;
        sprite[13][8] = Color.BLACK;
        sprite[13][9] = Color.BLACK;
        sprite[13][10] = Color.BLACK;
        sprite[13][11] = Color.BLACK;
        sprite[13][5] = Color.BLACK;
        //mouth
        sprite[14][4] = Color.WHITE;
        sprite[14][5] = Color.WHITE;
        sprite[14][6] = Color.WHITE;
        sprite[14][7] = Color.WHITE;
        sprite[14][8] = Color.WHITE;
        sprite[14][9] = Color.WHITE;
        sprite[14][10] = Color.WHITE;
        sprite[14][11] = Color.WHITE;
        sprite[15][4] = Color.WHITE;
        sprite[15][5] = Color.WHITE;
        sprite[15][6] = Color.WHITE;
        sprite[15][7] = Color.WHITE;
        sprite[15][8] = Color.WHITE;
        sprite[15][9] = Color.WHITE;
        sprite[15][10] = Color.WHITE;
        sprite[15][11] = Color.WHITE;
        sprite[16][5] = Color.WHITE;
        sprite[16][6] = Color.WHITE;
        sprite[16][7] = Color.WHITE;
        sprite[16][8] = Color.WHITE;
        sprite[16][9] = Color.WHITE;
        sprite[16][10] = Color.WHITE;

    }
}
