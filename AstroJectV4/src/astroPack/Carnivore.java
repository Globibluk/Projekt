package astroPack;

public abstract class Carnivore extends Dinosaur {

	public Carnivore(World world, int x, int y, int speed) {
		super(world, x, y, speed);
		world.addCList(this);
		
	}
	
	public Carnivore(World world, int speed) {
		super(world, speed);
		world.addCList(this);
	}

	public String toString() {
		return "Carnivore [toString()=" + super.toString() + ", getX()="
				+ getX() + ", getY()=" + getY() + "]";
	}

	

	
	
	

}
