package x_agents;

import java.awt.Image;

import worldInit.World;

public class Asteroid {
	
	private World world;
	
	private int x;
	private int y;
	
	private int xDest;
	private int yDest;
	
	private Image sprite;
	
	public Asteroid(World world, int x, int y, int xDest, int yDest) {
		
		this.x = x;
		this.y = y;
		this.xDest = xDest;
		this.yDest = yDest;
		this.world = world;
		
	}
	
	public void move() {
		
		if(x < xDest) x++;
		if(x > xDest) x--;
		if(y < yDest) y++;
		if(y > yDest) y--;
		
		if(x == xDest && y == yDest) world.impact(x, y);
	}
	
	

}
