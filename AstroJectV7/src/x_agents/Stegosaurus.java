package x_agents;

import worldInit.World;
import cells.Dirt;
import cells.Grass;

public class Stegosaurus extends Herbivore {
	
	private String spriteName = "sprites/prey.png";
	private String eggSpriteName = "sprites/herbi_egg.png";
		
	public Stegosaurus(World world, int x, int y, int speed) {
		super(world, x, y, speed);
		setSprite(spriteName);
		energyLoss = 250;											// a définir dans init
	}
	
	public Stegosaurus(World world, int speed) {
		super(world, speed);
		setSprite(spriteName);
		energyLoss = 250;
	}

	public String toString() {
		return "Stegosaurus [toString()=" + super.toString() + "]";
	}

	public void move() {
		moveWander();
		eat();
		dropEgg();
		this.setEnergy(getEnergy() - energyLoss);
		this.killHerbivore();
		
	}
	
	public void eat() {
		if(world.getMap()[x][y] instanceof Grass) {
			setEnergy(getEnergy() + 500);
			world.getMap()[x][y] = new Dirt(x, y);
		}
	}
	
	public void dropEgg() {
		if(testReprod()) {
			world.getMap()[x][y].setAlternateSprite(eggSpriteName);
			world.addEList(new Stego_egg(world, x, y, 10));
		}
	}

	public void changeToAlien() {
		speed++;
		energy = 1000;
		probMove = 0.8;
		//define sprite
		
	}
	
}
