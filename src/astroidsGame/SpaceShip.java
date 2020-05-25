package astroidsGame;

import graphics.Color;
import graphics.SpriteGraphicElement;

public class SpaceShip extends SpriteGraphicElement {

	private int maxX;

	public SpaceShip(int posX, int posY) {
		super(posX, posY);
		speedX = 1;  //move right
		sprite = new Color[2][3]; // sprite matrix must be created here
		maxX = 21; //outermost right position

		Color bodyColor = new Color (30,30,100);

		sprite[0][0] = Color.TRANSPARENT;
		sprite[0][1] = bodyColor;
		sprite[0][2] = Color.TRANSPARENT;

		sprite[1][0] = bodyColor;
		sprite[1][1] = bodyColor;
		sprite[1][2] = bodyColor;

	}

	public void update() {
		move();
	}

	public void move() {
		int nx = x + speedX;

		if (nx < 0 ) {
			nx = 0;
			speedX *= -1;
		} else if (nx > maxX) {
			nx = maxX;
			speedX *= -1;
		}
		setX(nx);
	}

	public int getSpeed() {
		return speedX;
	}

	public void setSpeed(int speed) {
		this.speedX = speed;
	}

	public boolean intersects(Projectile projectile) {
		int py = projectile.getY();
		int px = projectile.getX();

		//out of the range
		if (py < y || py > y + getHeight() || px < x || px > x + getWidth()) {
			return false;
		} else {
			return true;
		}
	}

}
