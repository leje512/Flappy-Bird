package display;

import lumenaer.PixelMatrix;
import java.awt.*;
import javax.swing.JPanel;

public class PixelMatrixPanel extends JPanel {

	int scale;
	PixelMatrix matrix;

	private Image offImg;
	private Graphics2D graphics2D;

	public PixelMatrixPanel(PixelMatrix matrix, int scale) {
		setDoubleBuffered(true);

		this.matrix = matrix;
		this.scale = scale;
	}

	public Dimension getPreferredSize() {
		return new Dimension(matrix.getHeight() * scale, matrix.getWidth() * scale);
	}

	private void offscreenPaint( Graphics g ) {

		int width = matrix.getWidth();
		int height = matrix.getHeight();

		//draw Pixel
		for (int y = 0; y < height; y++) {
			int ycoord = y * scale;

			for (int x = 0; x < width; x++) {
				int xcoord = x * scale;
				g.setColor(new Color(matrix.getIntValue(y, x)));
				g.fillRect(xcoord, ycoord, scale, scale);
			}
		}

		//drawGrid
		g.setColor(Color.black);
		for (int i = 0; i < width * scale ; i+= scale) {
			g.drawLine(i,0,i, height * scale);
		}
		for (int i = 0; i < height * scale ; i+= scale) {
			g.drawLine(0,i, width * scale,i);
		}

	}


	public void paint(Graphics g) {

		if (offImg == null) {
			offImg = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D) offImg.getGraphics();
		}

		offscreenPaint(graphics2D);
		g.drawImage(offImg, 0, 0, this);

	}

	public void update(Graphics g) {
		paint(g);
	}
}
