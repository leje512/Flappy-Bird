package lumenaer;

import graphics.Color;

public class PixelMatrix {

	private Color[][] pixel;
	private Color backgroundColor;

	public PixelMatrix(int height, int width) {
		this(width,height,Color.WHITE);
	}

	public PixelMatrix(int height, int width, Color backgroundColor) {
		pixel = new Color[height][width];
		this.backgroundColor = backgroundColor;
		drawBackground();
	}

	public int getHeight() {
		return pixel.length;
	}

	public int getWidth() {
		return pixel[0].length;
	}

	public Color getPixel(int y, int x) {
		return pixel[y][x];
	}

	public int getIntValue(int y, int x) {
		return pixel[y][x].getIntValue();
	}

	public void setPixel(int y, int x, Color color) {
		// only set a pixel if possible and not transparent
		if (y >= 0 && y < pixel.length &&
				x >= 0 && x < pixel[0].length &&
				color != Color.TRANSPARENT) {
			pixel[y][x] = color;
		}
	}

	public void drawBackground() {
		for (int y=0; y < getHeight(); y++) {
			for (int x=0; x < getWidth(); x++) {
				setPixel(y, x, backgroundColor);
			}
		}		
	}

	int[] getPixels() {
		int[] linearPixels = new int[pixel[0].length * pixel.length];
		int idx = 0;
		for (int y=0; y<getHeight(); y++) {
			for (int x=0; x<getHeight(); x++) {
				linearPixels[idx] = pixel[y][x].getIntValue();
				idx++;
			}
		}
		return linearPixels;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}


}
