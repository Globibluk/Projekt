package x_agents;

import worldInit.InitVar;
import worldInit.World;
import cells.Dirt;
import cells.Grass;

public class Stegosaurus extends Herbivore {

	private String spriteName = "sprites/prey.png";
	private String eggSpriteName = "sprites/herbi_egg.png";

	public Stegosaurus(World world, int x, int y, int speed) {
		super(world, x, y, speed);
		setSprite(spriteName);
		energyLoss = InitVar.getStegoEnergyLoss();
	}

	public Stegosaurus(World world, int speed) {
		super(world, speed);
		setSprite(spriteName);
		energyLoss = InitVar.getStegoEnergyLoss();
	}

	public String toString() {
		return "Stegosaurus [toString()=" + super.toString() + "]";
	}

	public void move() {
		moveWander();
		eat();
		if (this.timer > 15) {
			dropEgg();
		}
		this.setEnergy(getEnergy() - energyLoss);
		//check if he has energy left
		this.killHerbivore();
	
		//if it was a babydyno, check if he is a grown-up now
		addTimer();
		
		//if he is on a asteroid field, make him a mutant
		onAstro();

	}

	public void eat() {
		if (world.getMap()[intX][intX] instanceof Grass) {
			setEnergy(getEnergy() + 500);
			world.getMap()[intX][intY] = new Dirt(intX, intY);
		}
	}

	public void dropEgg() {
		if (testReprod() && !alien 
				//&& intX == x && intY == y	if you don't remove it, we have no kids
				) {
			world.getMap()[intX][intY].setAlternateSprite(eggSpriteName);
			world.addEList(new Stego_egg(world, intX, intY, 10));
		}
	}

	public void changeToAlien() {
		if (!alien) {
			speed++;
			energy = 3000;
			probMove = 0.8;
			setSprite("sprites/prey_alien.png");
			alien = true;
		}
	}

	public String getSpriteName() {
		return spriteName;
	}

}
