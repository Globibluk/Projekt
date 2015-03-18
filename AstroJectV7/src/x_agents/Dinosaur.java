package x_agents;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import worldInit.World;

public abstract class Dinosaur {

	protected World world;
	protected int x;
	protected int y;
	
	protected int energy;
	protected int energyLoss;
	
	protected final int vision = 5;
	
	protected int speed;
	protected double probMove = 0.4;
	
	private int reprodDelay;
	private int reprodTime;

	private Image sprite;
	private Image alternateSprite;
	
	// private int energyLoss; // perte d'�nergie sur d�placement

	public Dinosaur(World world, int x, int y, int speed) {

		this.world = world;
		this.x = x;
		this.y = y;
		this.speed = speed;
		energy = 1000;
		reprodDelay = (int) (Math.random() * 5 + 5);
		reprodTime = 0;
		
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
		reprodDelay = (int) (Math.random() * 5 + 5);
		reprodTime = 0;
		
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
	
	public Image getAlternateSprite() {
		return alternateSprite;
	}

	public void setSprite(String spriteName) {

		try {
			sprite = ImageIO.read(new File(spriteName));
		} catch (Exception e) {

			// introduire un sprite par défaut

		}
	}
	
	public void setAlternateSprite(String spriteName) {

		try {
			alternateSprite = ImageIO.read(new File(spriteName));
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
	
	public abstract void dropEgg();
	
	public abstract void changeToAlien ();
	
	public boolean testReprod() {
		if(reprodTime == reprodDelay) {
			reprodTime = 0;
			return true;
		}
		
		reprodTime++;
		return false;
		
	}		
}
