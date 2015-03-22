package x_agents;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import display.SpriteWorld;
import worldInit.World;

public class Asteroid {

	private World world;
	
	private int x;
	private int y;

	private int xDest;
	private int yDest;

	private Image sprite;
	private int spriteSize = 128;

	public Asteroid(int x, int y, int xDest, int yDest, World world) {

		this.world = world;
		this.x = x;
		this.y = y;
		this.xDest = xDest;
		this.yDest = yDest;
		
		try {
			sprite = ImageIO.read(new File("sprites/shadow.png"));
		} catch (Exception e) {
			sprite = null;
			System.out.println("Sprite non loaded");
		}
	}

	public void move() {

		if (x < xDest)
			x++;
		if (x > xDest)
			x--;
		if (y < yDest)
			y++;
		if (y > yDest)
			y--;
		if(x == xDest && y == yDest) world.impact(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXDest() {
		return xDest;
	}

	public int getYDest() {
		return yDest;
	}

	public Image getSprite() {
		return sprite;
	}

	public int getSpriteSize() {
		return spriteSize;
	}
	
}
