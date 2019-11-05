package astroidsGame;

import graphics.Color;
import graphics.SpriteGraphicObject;

public class SpaceShip extends SpriteGraphicObject {

	private int speed; // positive is right, negative is left
	private int maxX;

	public SpaceShip(int posX, int posY) {
		super(posX, posY);
		speed = 1;  //move right
		sprite = new Color[2][3];
		maxX = 21; //outermost right position

		Color bodyColor = new Color (30,30,100);

		sprite[0][0] = Color.TRANSPARENT;
		sprite[0][1] = bodyColor;
		sprite[0][2] = Color.TRANSPARENT;

		sprite[1][0] = bodyColor;
		sprite[1][1] = bodyColor;
		sprite[1][2] = bodyColor;

	}

	@Override
	public void update() {
		int nx = x+speed;

		if (nx < 0 ) {
			nx = 0;
			speed *= -1;
		} else if (nx > maxX) {
			nx = maxX;
			speed *= -1;
		}
		setX(nx);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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
