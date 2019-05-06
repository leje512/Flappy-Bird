package graphics;

import lumenaer.PixelMatrix;

public abstract class SpriteGraphicObject extends GraphicObject {

	protected Color[][] sprite;

	public SpriteGraphicObject(int posY, int posX) {
		super(posX,posY);
	}

	public int getWidth() {
		return sprite[0].length;
	}

	public int getHeight() {
		return sprite.length;
	}
	
	public void render(PixelMatrix matrix) {

		// just copy the sprite to the current Array
		// only the ones that are not tranparent
		if (sprite != null) {
			for (int i=0; i < sprite.length; i++ ) {
				for (int j=0; j < sprite[0].length; j++ ) {
					if (sprite[i][j] != Color.TRANSPARENT) {
						matrix.setPixel(y+i, x+j, sprite[i][j]);
					}
				}
			}
		}
	}

}
