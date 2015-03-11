package astroPack;

public class Stegosaurus extends Herbivore {
	
	private String spriteName = "sprites/prey.png";


	private final int energyLoss = 50;
		
	public Stegosaurus(World world, int x, int y, int speed) {
		super(world, x, y, speed);
		setSprite(spriteName);
	}
	
	public Stegosaurus(World world, int speed) {
		super(world, speed);
		setSprite(spriteName);
	}

	public String toString() {
		return "Stegosaurus [toString()=" + super.toString() + "]";
	}

	public void move() {
		
		moveWander();
		int energy = this.getEnergy();
		this.setEnergy(energy-energyLoss);
		this.killHerbivore();
		
	}
	
}
