package astroPack;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public abstract class Dinosaur {

	private World world;
	private int x;
	private int y;
	private int speed;
	private int energy;
	private double probMove = 0.4;
	private Image sprite;

	// private int energyLoss; // perte d'énergie sur déplacement

	public Dinosaur(World world, int x, int y, int speed) {

		this.world = world;
		this.x = x;
		this.y = y;
		this.speed = speed;
		energy = 1000;

	}

	public Dinosaur(World world, int speed) {

		this.world = world;

		do {

			x = (int) (Math.random() * world.getDx());
			y = (int) (Math.random() * world.getDy());

		} while (! world.getMap()[x][y].getAlternateSpriteName().equals(
				"reachable"));

		this.speed = speed;
		energy = 1000;
	}

	public String toString() {
		return "Dinosaur [world=" + world + ", x=" + x + ", y=" + y + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public World getWorld() {
		return world;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(String spriteName) {

		try {
			sprite = ImageIO.read(new File(spriteName));
		} catch (Exception e) {

			// introduire un sprite par défaut

		}
	}

	public abstract void move();

	public void moveWander() {

		int wDx = getWorld().getDx();
		int wDy = getWorld().getDy();
		int fx = getX();
		int fy = getY();

		if (Math.random() < probMove) {

			if (Math.random() < 0.5)
				fx = ((getX() + speed + wDx) % wDx);

			else
				fx = ((getX() - speed + wDx) % wDx);
		}

		if (Math.random() < probMove) {

			if (Math.random() < 0.5)
				fy = ((getY() + speed + wDy) % wDy);

			else
				fy = ((getY() - speed + wDy) % wDy);
			;
		}

		if (getWorld().getMap()[fx][fy].getAlternateSpriteName().equals(
				"reachable")) {
			setX(fx);
			setY(fy);
		}

	}

	public double distanceTo(int x1, int y1, int x2, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;
		return Math.sqrt(dx * dx + dy * dy);

	}

	public void moveStalk(int x1, int y1, int x2, int y2, int speed) { // x1 y1
																		// coordonnées
																		// du
																		// chasseur,
																		// x2 y2
																		// coordonnées
																		// de la
																		// proie
																		// gérer
																		// le
																		// thor
		int wDx = world.getDx();
		int wDy = world.getDy();

		if (x1 > x2) {

			if (x1 - speed < x2)
				setX(x2);
			else
				setX((x1 - speed + wDx) % wDx);
		}

		else {

			if (x1 - speed > x2)
				setX(x2);
			else
				setX((x1 + speed + wDx) % wDx);

		}

		if (y1 > y2) {

			if (y1 - speed < y2)
				setY(y2);
			else
				setY((y1 - speed + wDy) % wDy);
		}

		else {

			if (y1 - speed > y2)
				setY(y2);
			else
				setY((y1 + speed + wDy) % wDy);

		}

	}

}
