package x_agents;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import cells.Astro;
import worldInit.InitVar;
import worldInit.World;

public abstract class Dinosaur {

	protected World world;
	
	protected double x;
	protected double y;
	protected int intX;
	protected int intY;
	
	protected boolean moving;
	protected int moveCount;
	protected double xMoveDir;
	protected double yMoveDir;

	protected int energy = InitVar.getEnergy();
	protected int energyLoss;

	protected int vision = InitVar.getVision();
	
	protected int speed;
	protected double probMove = InitVar.getProbMove();

	private int reprodDelay;
	private int reprodTime;
	
	protected int timer = 0;

	private Image sprite;
	private Image alternateSprite;
	
	protected boolean alien = false;

	// private int energyLoss; // perte d'�nergie sur d�placement

	public Dinosaur(World world, int x, int y, int speed) {

		this.world = world;
		this.x = x;
		this.y = y;
		intX = x;
		intY = y;
		this.speed = speed;
		reprodDelay = (int) (Math.random() * 5 + 5);
		reprodTime = 0;
		moving = false;
		moveCount = 0;

	}

	public Dinosaur(World world, int speed) {

		this.world = world;

		do {

			x = (int) (Math.random() * world.getDx());
			y = (int) (Math.random() * world.getDy());

		} while (!world.getMap()[intX][intY].getAlternateSpriteName().equals(
				"reachable"));

		intX = (int) x;
		intY = (int) y;
		this.speed = speed;
		reprodDelay = (int) (Math.random() * 5 + 5);
		reprodTime = 0;
		moving = true;
		moveCount = 0;

	}

	public String toString() {
		return "Dinosaur [world=" + world + ", x=" + x + ", y=" + y + "]";
	}

	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public int getIntX() {
		return intX;
	}

	public void setIntX(int x) {
		intX = x;
	}

	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public int getIntY() {
		return intY;
	}

	public void setIntY(int y) {
		intY = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean isMoving() {
		return moving;
	}
	
	public void setMoving(boolean move) {
		moving = move;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public double getXMoveDir() {
		return xMoveDir;
	}
	
	public void setXMoveDir(double xDir) {
		xMoveDir = xDir;
	}
	
	public double getYMoveDir() {
		return yMoveDir;
	}
	
	public void setYMoveDir(double yDir) {
		yMoveDir = yDir;
	}
	
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
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

			System.out.println("Sprite non loaded :" + spriteName);

		}
	}

	public void setAlternateSprite(String alternateSpriteName) {

		try {
			alternateSprite = ImageIO.read(new File(alternateSpriteName));
		} catch (Exception e) {

			System.out.println("Alternate sprite non loaded:" + alternateSpriteName);

		}
	}

	public void addTimer() {
		timer++;
		if (timer == 15){
			setSprite(getSpriteName());
		}
	}
	
	public abstract String getSpriteName();

	public abstract void move();

	public void moveWander() {

		int wDx = getWorld().getDx();
		int wDy = getWorld().getDy();
		int fx = intX;
		int fy = intY;

		if (Math.random() < probMove) {

			if (Math.random() < 0.5)
				fx = (intX + speed + wDx) % wDx;

			else
				fx = (intX - speed + wDx) % wDx;
		}

		if (Math.random() < probMove) {

			if (Math.random() < 0.5)
				fy = (intY + speed + wDy) % wDy;

			else
				fy = (intY - speed + wDy) % wDy;			
		}

		if (getWorld().getMap()[fx][fy].getAlternateSpriteName().equals(
				"reachable")) {
			setIntX(fx);
			setIntY(fy);
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
																		
		int wDx = world.getDx();
		int wDy = world.getDy();

		if (x1 > x2) {

			if (x1 - speed < x2)
				setIntX(x2);
			else
				setIntX((x1 - speed + wDx) % wDx);
		}

		else {

			if (x1 - speed > x2)
				setIntX(x2);
			else
				setIntX((x1 + speed + wDx) % wDx);

		}

		if (y1 > y2) {

			if (y1 - speed < y2)
				setIntY(y2);
			else
				setIntY((y1 - speed + wDy) % wDy);
		}

		else {

			if (y1 - speed > y2)
				setIntY(y2);
			else
				setIntY((y1 + speed + wDy) % wDy);

		}

	}

	public abstract void dropEgg();

	public abstract void changeToAlien();

	public boolean testReprod() {
		//test if he can reproduce itself
		if (reprodTime == reprodDelay) {
			reprodTime = 0;
			return true;
		}

		reprodTime++;
		return false;

	}
	
	public void onAstro() {
		if(world.getMap()[intX][intY] instanceof Astro) changeToAlien();
	}
}
