package display;

import lumenaer.PixelMatrix;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PixelMatrixPanel extends JPanel {

	int scale;
	PixelMatrix matrix;

	public PixelMatrixPanel(PixelMatrix matrix, int scale) {
		this.matrix = matrix;
		this.scale = scale;
	}

	public Dimension getPreferredSize() {
		return new Dimension(matrix.getHeight() * scale, matrix.getWidth() * scale);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		int width = matrix.getWidth();
		int height = matrix.getHeight();

		for (int y = 0; y < height; y++) {
			int ycoord = y * scale;

			for (int x = 0; x < width; x++) {
				int xcoord = x * scale;
				g.setColor(new Color(matrix.getIntValue(y, x)));
				g.fillRect(xcoord, ycoord, scale, scale);
			}
		}

	}

}
