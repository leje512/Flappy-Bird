package graphics;

import lumenaer.PixelMatrix;

/**
 * Abstract base class for all sprite based GraphicElements. A sprite pixel matrix must be
 * created (and probably initialized) in the constructor.
 */

public abstract class SpriteGraphicElement extends GraphicElement {

	protected Color[][] sprite;

	public SpriteGraphicElement(int posX, int posY) {
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
		// only the ones that are not transparent
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
